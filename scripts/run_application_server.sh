echo '======================'
echo 'Running application_server'
echo '======================'

echo "> 현재 구동중인 애플리케이션 pid 확인"
IDLE_PID=$(pgrep -f around)

if [ -z "$IDLE_PID" ]
then
  echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
  echo "> kill -15 $IDLE_PID"
  kill -15 "$IDLE_PID"
  sleep 5
fi

BASE_PATH=/home/ec2-user/deploy
BUILD_PATH=$(ls $BASE_PATH/build/libs/*.jar)
JAR_NAME=$(basename "$BUILD_PATH")

echo "> build 파일명: $JAR_NAME"
nohup java -jar "$BUILD_PATH" > $BASE_PATH/nohup.out 2>&1 &
