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
	environment
	{
		AWS_DEFAULT_REGION='us-east-1'
		
	}
	
	agent any
	stages
	
	{
		stage('AWS Configure')
		{
			steps
			{
				sh 'aws --version'
				
				
				
				
			}		
		}
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
				withCredentials([aws(credentialsId: 'AWS_CREDENTIALS',aws_access_key: 'AWS_ACCESS_KEY_ID',aws_secret_access_key: 'AWS_SECRET_ACCESS_KEY')])
				
				{
					sh 'aws --version'
					echo "access key ${AWS_ACCESS_KEY_ID}"
					sh 'docker login -u AWS -p $(aws ecr-public get-login-password --region us-east-1) public.ecr.aws/s3p7e0c3'
					echo 'docker login successfull'
					sh 'docker tag app:latest public.ecr.aws/s3p7e0c3/collegeapp:latest'
					sh 'docker push public.ecr.aws/s3p7e0c3/collegeapp:latest'
					echo 'pushed image to ecr successfully'
				
				}
				
				
				
				
			}		
		}
		
	
	}

}
