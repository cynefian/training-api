package com.cynefian.base.core.landing;

import org.springframework.beans.factory.annotation.Value;

public class VersionObject {
	
	public String toString() {
		return "{buildVersion=" + buildVersion + ", buildBranch=" + buildBranch + 
				", buildEnv=" + buildEnv + ", gitHash=" + gitHash + 
				", buildTimestamp=" + buildTimestamp + 
				"}";
	}


	@Value("${ci.build.version}")
    private String buildVersion;
	
	@Value("${ci.build.branch}")
    private String buildBranch;
	
	@Value("${ci.build.env}")
    private String buildEnv;
	
	@Value("${ci.git.hash}")
    private String gitHash;
	
	@Value("${ci.build.timestamp}")
    private String buildTimestamp;
	
	@Value("${app.code}")
    private String appCode;
	
	@Value("${application.code}")
    private String applicationcode;


	public String getApplicationcode() {
		return applicationcode;
	}

	public void setApplicationcode(String applicationcode) {
		this.applicationcode = applicationcode;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getBuildVersion() {
		return buildVersion;
	}

	public void setBuildVersion(String buildVersion) {
		this.buildVersion = buildVersion;
	}

	public String getBuildBranch() {
		return buildBranch;
	}

	public void setBuildBranch(String buildBranch) {
		this.buildBranch = buildBranch;
	}

	public String getBuildEnv() {
		return buildEnv;
	}

	public void setBuildEnv(String buildEnv) {
		this.buildEnv = buildEnv;
	}

	public String getGitHash() {
		return gitHash;
	}

	public void setGitHash(String gitHash) {
		this.gitHash = gitHash;
	}

	public String getBuildTimestamp() {
		return buildTimestamp;
	}

	public void setBuildTimestamp(String buildTimestamp) {
		this.buildTimestamp = buildTimestamp;
	}
}
