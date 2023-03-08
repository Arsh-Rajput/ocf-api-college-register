pipeline
{
	tools
	{
		maven 'Maven'
	}
	parameters
	{
		choice(name: "Repository", choices: ["https://github.com/Arsh-Rajput/ocf-api-college-register.git"], description: "Repo Option")
		string(name: "branchToBuild", defaultValue:"master", description:"to select branch")
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
				echo "using setting from ${HOME}/.m2/setting.xml"
				sh 'mvn clean install'
				echo 'build project successfully'
				
				
			}		
		}
		stage('Docker Imgage')
		{
			steps
			{
				echo "Creating docker image"
				sh 'docker build -t app .'
				echo 'build image successfully'
				
				
			}		
		}
	
	}

}
