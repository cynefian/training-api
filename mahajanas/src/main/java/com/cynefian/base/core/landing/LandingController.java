package com.cynefian.base.core.landing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/version")
public class LandingController {
	
	@Autowired
    private Environment environment;

	@GetMapping
	public ResponseEntity<VersionObject> getAllActivities() {
		VersionObject version = new VersionObject();

		version.setBuildBranch(environment.getProperty("ci.build.branch"));
		version.setBuildVersion(environment.getProperty("ci.build.version"));
		version.setBuildEnv(environment.getProperty("ci.build.env"));
		version.setGitHash(environment.getProperty("ci.git.hash"));
		version.setBuildTimestamp(environment.getProperty("ci.build.timestamp"));
		
		return new ResponseEntity<VersionObject>(version, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@GetMapping("/appcode")
	public ResponseEntity<VersionObject> getAppcode() {
		VersionObject version = new VersionObject();

		
		version.setAppCode(environment.getProperty("app.code"));
		
		return new ResponseEntity<VersionObject>(version, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@GetMapping("/applicationcode")
	public ResponseEntity<VersionObject> getApplicationcode() {
		VersionObject version = new VersionObject();

		
		version.setApplicationcode(environment.getProperty("application.code"));
		
		return new ResponseEntity<VersionObject>(version, new HttpHeaders(), HttpStatus.OK);
	}


}
