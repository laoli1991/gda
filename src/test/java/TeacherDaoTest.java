import com.alibaba.fastjson.JSON;
import com.da.condition.TeacherQueryCondition;
import com.da.dao.TeacherMapper;
import com.da.po.Teacher;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: liyang117
 * @Date: 2018/6/30 12:31
 * @Description:
 */
public class TeacherDaoTest extends AbstractTest {

    @Autowired
    private TeacherMapper teacherDao;

    @Test
    public void testInsert() {
        Teacher teacher = new Teacher();
        teacher.setBirthPlace("上海");
        teacher.setEducation(1);
        teacher.setIdentityImgSrc("sdsd");
        teacher.setIdentityNO("42900");
        teacher.setName("李洋");
        teacher.setSex(1);
        teacher.setTeacherNo("12323");
        teacher.setUpdateBy("admin");
        teacherDao.insertSelective(teacher);
    }

    @Test
    public void testSelectByPrimaryKey() {
        Teacher teacher = teacherDao.selectByPrimaryKey(220094);
        System.out.println(JSON.toJSONString(teacher));
    }

    @Test
    public void testFindTeachers() {
        TeacherQueryCondition queryCondition = new TeacherQueryCondition();
        PageHelper.startPage(1, 8);
        //startPage后紧跟的这个查询就是分页查询
        List<Teacher> teachers = teacherDao.findTeachers(queryCondition);
        //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        PageInfo pageInfo = new PageInfo<Teacher>(teachers, 8);
        //pageINfo封装了分页的详细信息，也可以指定连续显示的页数
        System.out.println(JSON.toJSONString(pageInfo));
    }


}
