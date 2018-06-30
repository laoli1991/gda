import com.alibaba.fastjson.JSON;
import com.da.dao.TeacherMapper;
import com.da.po.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        Teacher teacher = teacherDao.selectByPrimaryKey(220067);
        System.out.println(JSON.toJSONString(teacher));
    }

}
