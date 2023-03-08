pipeline
{
	tools
	{
		maven 'Maven'
	}
	parameters
	{
		choice{name: "Repo", choices: ["https://github.com/Arsh-Rajput/ocf-api-college-register.git"], description: "Repo Option"}
		string(name: "branchToBuild", defaultValue="master", description="to select branch")
	}
	agent any
	stages
	{
		stage('git checkout')
		{
			steps
			{
				git ${Repo}
				echo 'copied repo'
				
			}		
		}
	
	}

}
