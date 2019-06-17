package com.yq.proxy;

public class StaticUserServiceProxy implements IUserService {
    //被代理的对象
    private IUserService target;

    /**
     * 通过构造方法传入代理对象
     * @param target
     */
    public StaticUserServiceProxy(IUserService target) {
        this.target = target;
    }

    @Override
    public void add(String name) {
        System.out.println("开启事务");
        target.add(name);
        System.out.println("提交事务");
    }
}
