echo '======================'
echo 'Running restart_server'
echo '======================'

nohup java -jar /home/ec2-user/deploy/aws-exercise/build/libs/aws-exercise-0.0.1-SNAPSHOT.jar &

sudo service nginx start
