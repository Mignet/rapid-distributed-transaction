# rapid-distributed-transaction
2p (Zookeeper) distributed transaction example

## dubbo bus(test-1,test-2,test-main)
1. run zookeeper
2. run test-1.com.v5ent.config.Web01Application
3. run test-2.com.jdw.config.Web02Application
4. run test-main.com.jdw.config.WebApplication

## distributed-transaction
1. access http://localhost:8888 , check the databases,insert records;
2. kill any provider then test
3. run the killed provider then test
4. more test
