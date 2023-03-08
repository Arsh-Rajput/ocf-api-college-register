pipeline
{
	tools
	{
		maven 'Maven'
	}
	parameters
	{
		choice{name: "Repo", choices: ["git@github.com:Arsh-Rajput/ocf-library-web-client.git"], description: "Repo Option"}
		string(name: "branchToBuild", defaultValue="master", description="to select branch")
	}
	agent any
	stages
	{
		stage('git checkout')
		{
			step
			{
				git ${Repo}
				echo 'copied repo'
				
			}		
		}
	
	}

}
