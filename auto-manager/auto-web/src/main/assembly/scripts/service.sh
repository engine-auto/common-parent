#!/bin/sh

# processname: agent-metrics
# description: agent-metrics is a monitor agent
# chkconfig: 2345 90 10
# description:  Start up the agent-metrics

## java env
 export JAVA_HOME=/usr/java/jdk1.7.0_71
 export JRE_HOME=$JAVA_HOME/jre

## service name
APP_NAME=${artifactId}-${version}

filepath=$(cd "$(dirname "$0")"; pwd)
SERVICE_DIR=$filepath
SERVICE_NAME=$APP_NAME
PID=$SERVICE_NAME\.pid

cd $SERVICE_DIR

case "$1" in

    start)
        nohup $JRE_HOME/bin/java -jar ../lib/${artifactId}-${version}.jar >/dev/null 2>log &
        echo $! > $SERVICE_DIR/$PID
        echo "=== start $SERVICE_NAME"
        ;;

    stop)
		if [ -f $SERVICE_DIR/$PID ]
        then
			kill `cat $SERVICE_DIR/$PID`
			rm -rf $SERVICE_DIR/$PID
			echo "=== stop $SERVICE_NAME"
			sleep 5
        fi    

		##
		## edu-service-aa.jar

        P_ID=`ps -ef | grep -w "$SERVICE_NAME" | grep -v "grep" | awk '{print $2}'`
        if [ "$P_ID" == "" ]; then
            echo "=== $SERVICE_NAME process not exists or stop success"
        else
            echo "=== $SERVICE_NAME process pid is:$P_ID"
            echo "=== begin kill $SERVICE_NAME process, pid is:$P_ID"
            #kill -9 $P_ID   
            pkill -U $P_ID
        fi
        ;;

    restart)
        $0 stop
        sleep 2
        $0 start
        echo "=== restart $SERVICE_NAME"      
        ;;
    *)
        ## restart
	$0 stop
        sleep 2
        $0 start
        ;;

esac
exit 0
