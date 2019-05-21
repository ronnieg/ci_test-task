folder('job_dsl') { 

   description('folder for pipeline job')
  
}
pipelineJob('job_dsl/pipeline') {
      def repo = 'https://github.com/AndreyNovik1993/ci_test-task.git' 
      description("Pipeline for $repo") 
      definition { 
          cpsScm { 
             scm { 
               git { remote { url(repo) } 
               branches('master', '**/feature*') 
               scriptPath('Jenkinsfile') 
               extensions { } 
		}
	 } 
      } 
   } 
queue('job_dsl/pipeline')
}
