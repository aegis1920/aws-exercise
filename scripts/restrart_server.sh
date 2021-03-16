echo '======================'
echo 'Running restart_server'
echo '======================'

nohup java -jar /home/ec2-user/deploy/build/libs/aws-exercise-0.0.1-SNAPSHOT.jar /dev/null 2> /dev/null < /dev/null &

sudo service nginx start
