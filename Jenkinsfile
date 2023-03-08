pipeline
{
	tools
	{
		maven 'Maven'
	}
	
	agent any
	stages
	{
		stage('git checkout')
		{
			steps
			{
				git "${Repository}"
				echo 'copied repo'
				
			}		
		}
		stage('Build')
		{
			steps
			{
				sh 'mvn clean install'
				echo 'build project successfully'
				
			}		
		}
	
	}

}
