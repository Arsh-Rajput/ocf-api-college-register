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
		stage('AWS login')
		{
			steps
			{
				
				sh 'aws ecr-public get-login-password --region us-east-1 | docker login --username AWS --password-stdin public.ecr.aws/s3p7e0c3'
				
				
				
			}		
		}
		stage('AWS ECR Push')
		{
			steps
			{
				
				sh 'docker tag app:latest public.ecr.aws/s3p7e0c3/collegeapp:latest'
				sh 'docker push public.ecr.aws/s3p7e0c3/collegeapp:latest'
				echo 'pushed image to ecr successfully'
				
				
				
			}		
		}
		
	
	}

}
