package interview.vivo.校招2020A;

import java.util.List;

/**
 * 小v是公司的运维工程师，现有一个有关应用程序部署的任务如下：
 * 1、一台服务器的磁盘空间、内存是固定的，现在有N个应用程序要部署；
 * 2、每个应用程序所需要的磁盘、内存不同，每个应用程序允许访问的用户数也不同，且同一个应用程序不能在一台服务器上部署多个。
 * 对于一台服务器而言，如何组合部署应用程序能够使得单台服务器允许访问的用户数最多？
 *
 * @author Ikaros
 * @date 2020/6/4 15:04
 */
public class A {
    static int[] visited;
    static int result = Integer.MIN_VALUE;
    
    private static int solution(int totalDisk, int totalMemory, List<Service> services) {
        visited = new int[services.size()];
        dfs(totalDisk, totalMemory, services, 0, 0);
        return result;
    }
    
    private static void dfs(int totalDisk, int totalMemory, List<Service> services, int totalUser, int i) {
        if (totalUser > result) {
            result = totalUser;
        }
        for (; i < services.size(); i++) {
            Service service = services.get(i);
            if (visited[i] == 0 && totalDisk >= service.disk && totalMemory >= service.memory) {
                visited[i]++;
                dfs(totalDisk - service.disk, totalMemory - service.memory, services, totalUser + service.users, i + 1);
                visited[i]--;
            }
        }
    }
    
    static class Service {
        private int disk;
        
        private int memory;
        
        private int users;
        
        public Service(int disk, int memory, int users) {
            this.disk = disk;
            this.memory = memory;
            this.users = users;
        }
        
        public int getDisk() {
            return disk;
        }
        
        public void setDisk(int disk) {
            this.disk = disk;
        }
        
        public int getMemory() {
            return memory;
        }
        
        public void setMemory(int memory) {
            this.memory = memory;
        }
        
        public int getusers() {
            return users;
        }
        
        public void setusers(int users) {
            this.users = users;
        }
    }
}
