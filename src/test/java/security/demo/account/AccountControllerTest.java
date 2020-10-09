package security.demo.account;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithAnonymousUser
	public void index_anonymous() throws Exception {
		mockMvc.perform(get("/"))
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void index_user() throws Exception {
		mockMvc.perform(get("/").with(user("test").roles("USER")))
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	public void index_admin1() throws Exception {
		mockMvc.perform(get("/admin").with(user("test").roles("USER")))
			.andDo(print())
			.andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(username = "test", roles = "ADMIN")
	public void index_admin2() throws Exception {
		mockMvc.perform(get("/admin"))
			.andDo(print())
			.andExpect(status().isOk());
	}

	@Test
	@WithTestUser
	public void index_admin3_withTestUser() throws Exception {
		mockMvc.perform(get("/admin"))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
