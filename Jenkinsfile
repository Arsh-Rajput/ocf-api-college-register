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
		
		stage('AWS ECR Push')
		{
			steps
			{
				withEnv(["AWS_ACCESS_KEY_ID=${env.AWS_ACCESS_KEY}","AWS_SECRET_ACCESS_KEY=${env.AWS_SECRET_KEY}","AWS_DEFAULT_REGION=us-east-1"])
				{
					echo "access key ${AWS_ACCESS_KEY_ID}"
					sh 'docker login -u AWS -p $(aws ecr-public get-login-password --region us-east-1) public.ecr.aws/s3p7e0c3'
					sh 'docker tag app:latest public.ecr.aws/s3p7e0c3/collegeapp:latest'
					sh 'docker push public.ecr.aws/s3p7e0c3/collegeapp:latest'
					echo 'pushed image to ecr successfully'
				
				}
				
				
				
				
			}		
		}
		
	
	}

}
