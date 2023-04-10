module java8 {
    requires java.base;
    requires java.sql;
    requires java.xml;
    requires java.scripting;
    requires java.desktop;
    requires java.persistence;
    requires java.xml.bind;
    requires java.annotation;
    requires spring.beans;
    requires spring.aop;
    requires spring.jdbc;
    requires spring.context;
    requires spring.batch.core;
    requires spring.tx;
    requires spring.batch.infrastructure;
    requires com.google.protobuf;
    requires com.google.common;
    requires org.aspectj.weaver;
    requires org.hibernate.orm.core;
    requires org.bouncycastle.provider;
    requires org.apache.pdfbox;
    requires org.apache.commons.lang3;
    requires commons.dbcp;
    requires commons.io;
    requires org.jetbrains.annotations;
    requires spymemcached;
    requires junit;
    requires org.jdom2;
    requires jackson.core.asl;
    requires jackson.mapper.asl;
    requires et;
    exports demo.java.com.proto.model;
}