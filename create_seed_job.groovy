folder('project_test') { 

   description('folder for pipeline job')
  
}

pipelineJob('project_test/test_pipeline') {
  
    def repo = 'https://github.com/AndreyNovik1993/ci_test-task.git'

  description("Pipeline for $repo")

  definition {
    cpsScm {
      scm {
        git {
          remote { url(repo) }
          branches('master', '**/feature*')
          scriptPath('Jenkinsfile')
          extensions { } 
        }
      }
    }
  }
}
