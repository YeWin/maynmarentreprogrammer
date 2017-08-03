package com.mep.security.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mep.security.service.AdminDetailsServiceImpl;

/**
 * Spring Security設定クラス
 *
 * @author TechFun
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(WebSecurity web) throws Exception{
		// セキュリティ設定を無視するリクエスト設定
		web.ignoring().antMatchers("/theme/**");
	}

	@Override
	protected void configure(HttpSecurity http)throws Exception{

		// 認可の設定
		http.authorizeRequests()
			.antMatchers("/login",
						"/login-error",
						"/admin/input",
						"admin/**",
						"/admin/confirm",
						"/admin/complete",
						"/auth").permitAll()	// 認証無しでアクセスを許可
			.anyRequest().authenticated();		// それ以外は全て認証無しの場合アクセス不許可

		// ログイン設定
		http.formLogin()
			.loginProcessingUrl("/auth")									// 認証処理のパス
			.loginPage("/login")											// ログインフォームのパス
			.failureForwardUrl("/login-error")								// 認証失敗時の遷移先
			.defaultSuccessUrl("/login-success", true)						// 認証成功時の遷移先(固定)
			.usernameParameter("adminEmail")										// ユーザ名
			.passwordParameter("adminPassword")									// パスワード
			.and();

		// ログアウト設定
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))	// ログアウト処理のパス
			.logoutSuccessUrl("/login")										// ログアウト完了時のパス
			.invalidateHttpSession(true);									// セッションの破棄
	}

	@Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        AdminDetailsServiceImpl userDetailsService;

        @Bean //パスワードの暗号化方式
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            // 認証するユーザーを設定する
            auth.userDetailsService(userDetailsService)
            // 入力値をbcryptでハッシュ化した値でパスワード認証を行う
            .passwordEncoder(passwordEncoder());
        }
    }
}
