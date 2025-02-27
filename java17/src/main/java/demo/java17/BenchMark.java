package demo.java17;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *  * time java --enable-preview --source 13 -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=G1.jfr,maxsize=1024m,settings=profile BenchMark
 *  * time java --enable-preview --source 13 -XX:+UseParallelOldGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=ParallelOld.jfr,maxsize=1024m,settings=profile BenchMark
 *  * time java --enable-preview --source 13 -XX:+UseConcMarkSweepGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=CMS.jfr,maxsize=1024m,settings=profile BenchMark
 *  * time java --enable-preview --source 13 -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=Shenandoah.jfr,maxsize=1024m,settings=profile BenchMark
 *  * time java --enable-preview --source 13 -XX:+UnlockExperimentalVMOptions -XX:+UseZGC -Xms4G -Xmx8G -XX:StartFlightRecording=disk=true,dumponexit=true,filename=ZGC.jfr,maxsize=1024m,settings=profile BenchMark
 *
 *  * time java -XX:ArchiveClassesAtExit=temp.jsa BenchMark.java
 *  * time java -XX:SharedArchiveFile=temp.jsa BenchMark.java
 *
 */

public class BenchMark {
    static List<Object> l;

    public static void main(String... args) {
        l = new ArrayList<>();
        for (int c = 0; c < 100_000_000; c++) {
            l.add(new Object());
        }
        System.out.println("Hello Java 13!");
        System.out.println("Running " + ManagementFactory.getRuntimeMXBean().getUptime() + "ms.");
    }
}
