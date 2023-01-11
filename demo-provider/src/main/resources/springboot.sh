#!/bin/sh

APP_PATH=/home/lighthouse/apps/demo
APP_NAME=demo-provider.jar
LOG_FILE=run.log
PORT=8081

#使用说明，用来提示输入参数
usage() {
    echo "Usage: sh springboot.sh [start|stop|restart|status|log]"
    exit 1
}

#检查程序是否在运行
is_exist() {
    pid=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}'`
    #如果不存在返回1，存在返回0
    if [ -z "${pid}" ]; then
        return 1
    else
        return 0
    fi
}

#启动方法
start(){
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME} is already running. pid=${pid} ."
  else
    nohup java -jar ${APP_PATH}/${APP_NAME} > ${APP_PATH}/${LOG_FILE} &
    # nohup java -jar ${APP_PATH}/${APP_NAME} --spring.config.location=${CONF_PATH} --spring.profiles.active=dev >${LOG_FILE} 2>&1 &
    echo "${APP_NAME} start success"
    # sleep 0.5
    # rm -rf ${LOG_FILE}
    # echo "delete ${LOG_FILE}"
  fi
}

#停止方法
stop(){
  is_exist
  if [ $? -eq "0" ]; then
    kill -9 ${pid}
    echo "${APP_NAME} is stop"
  else
    echo "${APP_NAME} is not running"
  fi
}

#运行状态
status(){
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME} is running. Pid is ${pid}"
  else
    echo "${APP_NAME} is NOT running."
  fi
}

#重启
restart(){
  stop
  sleep 0.5
  start
}

#查看日志
log(){
  tail -f ${APP_PATH}/${LOG_FILE}
}

#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
  "start")
    start
    ;;
  "stop")
    stop
    ;;
  "status")
    status
    ;;
  "restart")
    restart
    ;;
  "log")
    log
    ;;
  *)
    usage
    ;;
esac







#cd $APP_PATH
#if [[ $1 = 'start' ]]; then
#    nohup java -jar demo-provider.jar > run.log &
#    tail -f run.log
#elif [[ $1 = 'stop' ]]; then
#    # 获取此端口运行的进程
#    # pid=`lsof -t -i:$PORT`
#    pid=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}'`
#    # 判断如果进程号不为空则，关闭进程
#    if [[ $pid = '' ]]; then
#        echo "demo-provider 工程未启动！"
#    else
#        kill -9 $pid
#        echo "demo-provider 工程进程$pid 关闭成功！"
#    fi
#else
#    echo "nothing to do."
#fi