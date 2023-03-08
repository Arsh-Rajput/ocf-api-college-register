pipeline
{
	tools
	{
		maven 'Maven'
	}
	parameters
	{
		choice(name: "Repository", choices: ["git@github.com:Arsh-Rajput/ocf-api-college-register.git"], description: "Repo Option")
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
				sh 'mvn clean install'
				echo 'build project successfully'
				
			}		
		}
	
	}

}
