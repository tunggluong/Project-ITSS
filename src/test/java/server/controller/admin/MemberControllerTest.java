package server.controller.admin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import server.model.Member;
import server.service.MemberService;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Mock
    private MemberService memberService;
    @Mock
    private Model model;

    @Autowired
    MemberController underTest;

    @BeforeEach
    public void setup() {
        String createTableSql = "CREATE TABLE member (" +
                "member_account varchar(255) NOT NULL UNIQUE COMMENT 'Member Account'," +
                "member_password varchar(255) NULL DEFAULT '123456' COMMENT 'Member Password'," +
                "member_name varchar(255) NULL DEFAULT NULL COMMENT 'Member Name'," +
                "member_gender varchar(255) NULL DEFAULT '' COMMENT 'Member Gender'," +
                "member_age int NULL DEFAULT NULL COMMENT 'Age'," +
                "member_height int NULL DEFAULT NULL COMMENT 'Height in cm'," +
                "member_weight int NULL DEFAULT NULL COMMENT 'weight in kg'," +
                "member_phone varchar(10) NULL DEFAULT NULL COMMENT 'phone'," +
                "active BOOLEAN NULL DEFAULT TRUE COMMENT 'active or not'," +
                "PRIMARY KEY (member_account)" +
                ")";

        jdbcTemplate.execute(createTableSql);

        String insertRecordsSql = "INSERT INTO member (member_account, member_password, member_name, member_gender, member_age, member_height, member_weight, member_phone) VALUES "
                +
                "('202009867', '123456', 'Nguyễn', 'female', 24, 182, 60, '0515548482')," +
                "('202100788', '123456', 'Thái', 'male', 31, 178, 60, '0131554873')," +
                "('202132539', '123456', 'Bình', 'male', 31, 178, 60, '0154875489')," +
                "('202186416', '123456', 'Hoàng', 'female', 23, 160, 45, '0124576857')," +
                "('202106725', '123456', 'Huy', 'male', 24, 178, 88, '0758784959')," +
                "('202183406', '123456', 'Hiếu', 'female', 19, 170, 60, '0786457488')," +
                "('202176587', '123456', 'Dương', 'male', 33, 177, 90, '0767546666')," +
                "('202156754', '123456', 'Ronaldo', 'male', 36, 166, 67, '0786532448')," +
                "('202153468', '123456', 'Messi', 'female', 25, 173, 44, '0786457124')," +
                "('202121345', '123456', 'Mbappe', 'male', 28, 160, 40, '0754457488')," +
                "('202189776', '123456', 'Haland', 'female', 27, 170, 50, '0986337489')," +
                "('202123664', '123456', 'Alice', 'female', 25, 165, 51, '0986457423')";

        jdbcTemplate.execute(insertRecordsSql);
    }

    @AfterEach
    public void tearDown() {
        String dropTableSql = "DROP TABLE IF EXISTS member";
        jdbcTemplate.execute(dropTableSql);
    }

    @Test
    void testSelectMember() throws Exception {
        mockMvc.perform(get("/member/selMember"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/selectMember"))
                .andExpect(model().attributeExists("memberList"));
    }

    @Test
    void testToAddMember() throws Exception {
        mockMvc.perform(get("/member/toAddMember"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/addMember"));
    }

    @Test
    void testToUpdateMember() throws Exception {
        mockMvc.perform(get("/member/toUpdateMember"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/updateMember"))
                .andExpect(model().attributeExists("memberList"));
    }

    @Test
    void testAddMemberSuccess() {
        // given
        Member member = new Member();
        member.setMemberAccount("testAccount");
        member.setMemberPassword("testPassword");
        member.setMemberName("testName");
        member.setMemberGender("Male");
        member.setMemberAge(20);
        member.setMemberHeight(180);
        member.setMemberWeight(80);
        member.setMemberPhone("0123456789");

        // when
        String result = underTest.addMember(member, model);

        // then
        assertThat(result).isEqualTo("redirect:selMember");

        Map<String, Object> queryResult = jdbcTemplate
                .queryForMap("SELECT * FROM member WHERE member_account = 'testAccount'");
        assertThat(queryResult.get("member_account")).isEqualTo("testAccount");
        assertThat(queryResult.get("member_password")).isEqualTo("testPassword");
        assertThat(queryResult.get("member_name")).isEqualTo("testName");
        assertThat(queryResult.get("member_gender")).isEqualTo("Male");
        assertThat(queryResult.get("member_age")).isEqualTo(20);
        assertThat(queryResult.get("member_height")).isEqualTo(180);
        assertThat(queryResult.get("member_weight")).isEqualTo(80);
        assertThat(queryResult.get("member_phone")).isEqualTo("0123456789");
        assertThat(queryResult.get("active")).isEqualTo(true);
    }

    @Test
    void testAddMemberWithNullAccount() {
        // given
        Member member = new Member();
        member.setMemberPassword("testPassword");
        member.setMemberName("testName");
        member.setMemberGender("Male");
        member.setMemberAge(20);
        member.setMemberHeight(180);
        member.setMemberWeight(80);
        member.setMemberPhone("0123456789");

        // when
        Throwable exception = assertThrows(DataIntegrityViolationException.class, () -> {
            underTest.addMember(member, model);
        });

        // then
        assertThat(exception).isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    void testAddMemberWithLongAccount() {
        // given
        Member member = new Member();
        member.setMemberAccount("a".repeat(256)); // Set account with more than 255 characters
        member.setMemberPassword("testPassword");
        member.setMemberName("testName");
        member.setMemberGender("Male");
        member.setMemberAge(20);
        member.setMemberHeight(180);
        member.setMemberWeight(80);
        member.setMemberPhone("0123456789");

        // when
        Throwable exception = assertThrows(DataIntegrityViolationException.class, () -> {
            underTest.addMember(member, model);
        });

        // then
        assertThat(exception).isInstanceOf(DataIntegrityViolationException.class);
    }

    @Test
    void testAddMemberWithNonUniqueAccount() {
        // given
        Member member = new Member();
        member.setMemberAccount("202009867"); // Set non-unique account (already exists in the database)
        member.setMemberPassword("testPassword");
        member.setMemberName("testName");
        member.setMemberGender("Male");
        member.setMemberAge(20);
        member.setMemberHeight(180);
        member.setMemberWeight(80);
        member.setMemberPhone("0123456789");

        // when
        Throwable exception = assertThrows(DuplicateKeyException.class, () -> {
            underTest.addMember(member, model);
        });

        // then
        assertThat(exception).isInstanceOf(DuplicateKeyException.class);
    }

    @Test
    void testDeleteMember() throws Exception {
        mockMvc.perform(get("/member/delMember?memberAccount=202009867"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:selMember"));

        Map<String, Object> queryResult = jdbcTemplate
                .queryForMap("SELECT * FROM member WHERE member_account = '202009867'");
        assertThat(queryResult.get("active")).isEqualTo(false);
    }
}
