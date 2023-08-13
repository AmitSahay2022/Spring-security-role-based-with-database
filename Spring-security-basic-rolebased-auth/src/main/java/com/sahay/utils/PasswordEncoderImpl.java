package com.sahay.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl {
	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("user"));

		System.out.println(passwordEncoder.encode("admin"));
	}
}


// $2a$10$Uj/FZfp/vL9DsKeZCkTmEuNrryJZc/A4DCupNArtuDw1MLSdlsBwK
// $2a$10$rvPlITxSo04bvAuFpUsyYOIZxMYa3IHwwXwgTXGkkhJoRStTW62TC