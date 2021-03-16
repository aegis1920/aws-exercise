echo '============================'
echo 'Running install_dependencies'
echo '============================'

source /home/ec2-user/.bash_profile

cd /home/ec2-user/deploy
./gradlew clean build
