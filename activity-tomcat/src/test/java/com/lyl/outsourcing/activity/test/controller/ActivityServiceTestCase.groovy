package com.lyl.outsourcing.activity.test.controller

import com.lyl.outsourcing.activity.common.Global
import com.lyl.outsourcing.activity.common.XUtil
import com.lyl.outsourcing.activity.dto.Result
import com.lyl.outsourcing.activity.dto.request.ActivityForm
import com.lyl.outsourcing.activity.entity.Activity
import com.lyl.outsourcing.activity.exception.FieldException
import com.lyl.outsourcing.activity.service.ActivityService
import com.lyl.outsourcing.activity.test.TestBase
import com.lyl.outsourcing.activity.test.VoteServiceTestCase
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

/**
 * Created by liyilin on 2017/4/30.
 */
class ActivityServiceTestCase extends TestBase {
    static Set<Long> idSet = new HashSet<>()

    @Test
    void test1_save() {
        String name = UUID.randomUUID().toString().replace("-", "").substring(0, 30)
        ActivityForm activityForm = new ActivityForm()
        activityForm.name = name
        activityForm.startTime = XUtil.parse("2017-04-01 00:00:00")
        activityForm.endTime = XUtil.parse("2017-06-01 00:00:00")

        println XUtil.toJson(activityForm)

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/activity")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(XUtil.toJson(activityForm))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()

        Result result = getResult(mvcResult)
        assertResult(result, 0)
        idSet << (result.data as Activity).id
    }

    @Test
    void testDelete() {
        Set<Long> set = saveBatch(5)
        Result result = activityService.delete(set)
        assert result.code == 0 : "${result.code}: ${result.msg}"
        result.data.each {
            assert it.msg == null: "${it.id}: ${it.msg}"
        }
    }

    @Test
    void testGetById() {
        final id = saveBatch(1)[0] as long
        Result result = activityService.getById(id)
        assert result.code == 0 : "${result.code}: ${result.msg}"
        println XUtil.toJson(result.data)
    }

    @Test
    void testUpdateName() {
        final long id = saveBatch(1)[0] as long
        final String name = "asdofjasodifjosadij"

        def activity = activityService.getById(id).data as Activity
        ActivityForm activityForm = new ActivityForm()
        XUtil.copy(activity, activityForm)
        activityForm.name = name

        def result = activityService.update(activityForm)
        assert result.code == 0 : "${result.code}: ${result.msg}"
        assert (result.data as Activity).name == name
    }

    @Test
    void testUpdateTime() {
        final id = saveBatch(1)[0] as long
        VoteServiceTestCase.saveBatch(1, id)

        def activity = activityService.getById(id).data as Activity
        ActivityForm activityForm = new ActivityForm()
        XUtil.copy(activity, activityForm)
        activityForm.startTime = new Date() + 1

        try {
            activityService.update(activityForm)
            assert false: "活动开始时间必须早于或等于该活动下所有投票主题的开始时间"
        } catch (FieldException e) {
            assert e.field == "startTime"
        }

        activityForm.startTime = new Date()-1
        activityForm.endTime = new Date()+1
        try {
            activityService.update(activityForm)
            assert false: "活动结束时间必须迟于或等于该活动下所有投票主题的结束时间"
        } catch (FieldException e) {
            assert e.field == "endTime"
        }

        activityForm.startTime = new Date()-1
        activityForm.endTime = new Date()-2
        try {
            activityService.update(activityForm)
            assert false: "开始时间必须早于结束时间"
        } catch (FieldException e) {
            assert e.field == "startTime"
        }
    }

    @Test
    void testPage() {
        saveBatch(50)
        def result = activityService.page("", 1, 3)
        assert result.code == 0 : "${result.code}: ${result.msg}"
        println XUtil.toJson(result.data)
    }

    static saveBatch(int num) {
        def ans = []
        final ActivityService activityService = Global.applicationContext.getBean(ActivityService.class)
        num.times {

        }
        ans
    }
}
