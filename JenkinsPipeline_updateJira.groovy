/**
 * Updates Jira Fixed in build field with the build number and adds a comment in each related Jira issue
 * This requires the Jenkins JIRA Pipeline Steps plugin https://jenkinsci.github.io/jira-steps-plugin/getting-started/
 * @param build Build number that will be entered in the "Fixed in Build" Jira field
 */
def updateJira(build) {
	def jiraServer = 'JIRA-PROD' // Define a Jira server entry in the Jenkins Jira Steps configuration named JIRA-PROD
  def jiraIssues = jiraIssueSelector(issueSelector: [$class: 'DefaultIssueSelector'])
	jiraIssues.each { issue ->
		jiraAddComment comment: "{panel:bgColor=#97FF94}{code}Code was added to address this issue in build ${build}{code} {panel}", idOrKey: issue, site: jiraServer
		def fixedInBuild = [fields: [customfield_10121: build]] // This is a custom field named "Fixed in Build"
        jiraEditIssue idOrKey: issue, issue: fixedInBuild, site: jiraServer
    }
}