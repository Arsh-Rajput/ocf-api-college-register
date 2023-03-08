pipeline
{
	tools
	{
		maven 'Maven'
	}
	parameters
	{
		choice(name: "Repository", choices: ["git@github.com:Arsh-Rajput/ocf-library-web-client.git"], description: "Repo Option")
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
				mvn clean install
				echo 'build project successfully'
				
			}		
		}
	
	}

}
