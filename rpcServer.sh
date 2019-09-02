#!/usr/bin/env bash
#description: writeStock
path=/opt/develop/writeStock
tpid=`ps aux | grep -c '$path/writeStock-1.0.jar'`

case "$1" in

start)
if [ $tpid -le 1 ]; then
echo "writeStock service start..."


/usr/local/jdk1.8/jdk1.8.0_65/bin/java -Xms64m -Xmx128m -jar $path/writeStock-1.0.jar >> $path/youguu.out 2>&1 &
echo $! > $path/server.pid
else
echo "writeStock service already started.PID: `cat $path/server.pid`"
exit 0
fi
;;

stop)
echo "writeStock service stop..."
kill -9 `cat $path/server.pid`
rm -rf $path/server.pid
;;

restart)
echo "writeStock service restart..."
$0 stop
sleep 1
$0 start
;;

*)
echo "Usage: writeStock.sh(start|stop|restart)"
esac

exit 0