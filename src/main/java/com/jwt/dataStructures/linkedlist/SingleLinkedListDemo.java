package com.jwt.dataStructures.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();
    }

    static class SingleLinkedList {
        //先定义一个头结点,不放任何信息
        private HeroNode head = new HeroNode(0, "", "");

        /**
         * 添加节点到单向链表
         * 思路，当不考虑编号顺序时
         * 1.找到当前链表的最后节点
         * 2.将最后这个节点的next指向新的节点
         *
         * @param heroNode
         */
        public void add(HeroNode heroNode) {
            //定义个辅助变量来遍历,相当于指针
            //用=赋值的时候 是修改的对象指向的内存地址
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                }
                //指针后移
                temp = temp.next;
            }
            //当退出while循环时，
            // temp就指向了链表的最后
            // 将最后这个节点的next指向新的节点
            temp.next = heroNode;
        }

        //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
        // (如果有这个排名，则添加失败，并给出提示)
        public void addByOrder(HeroNode heroNode) {
            //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
            // 因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
            HeroNode temp = head;
            boolean flag = false;//flag标志添加的编号是否存在，默认为false
            while (true) {
                if (temp.next == null) {
                    //说明temp已经在链表的最后
                    break;
                }
                if (temp.next.no > heroNode.no) {
                    //位置找到，就在temp的后面插入
                    break;
                } else if (temp.next.no == heroNode.no) {
                    //说明希望添加的heroNode的编号已然存在
                    flag = true;//说明编号存在
                }
                break;
            }
            temp = temp.next;//后移，遍历当前链表
            //判断flag的值
            if (flag) {
                //不能添加，说明编号存在
                System.out.printf("准备插入的英雄的编号%d已经存在了,不能加入\n", heroNode.no);
            } else {
                //插入到链表中,temp的后面
                heroNode.next = temp.next;
                temp.next = heroNode;
            }
        }


        //修改节点的信息,根据no编号来修改，即no编号不能改.
        // 1.根据newHeroNode的no来修改即可
        public void update(HeroNode newHeroNode) {
            //判断是否空
            if (head.next == null) {
                System.out.println("链表为空~");
                return;
            }
            //找到需要修改的节点,根据no编号
            // 定义一个辅助变量
            HeroNode temp = head.next;
            boolean flag = false;//表示是否找到该节点
            while (true) {
                if (temp == null) {
                    break;
                    //已经遍历完链表
                }
                if (temp.no == newHeroNode.no) {
                    //找到
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            //根据flag判断是否找到要修改的节点
            if (flag) {
                temp.name = newHeroNode.name;
                temp.nickname = newHeroNode.nickname;
            } else {
                //没有找到
                System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
            }
        }


        //删除节点
        //1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
        // 2.说明我们在比较时，是temp.next.no和需要删除的节点的no比较
        public void delete(int no) {
            HeroNode temp = head;
            boolean flag = false;//标志是否找到待删除节点的
            while (true) {
                if (temp.next == null) {
                    break;
                }
                //找到的待删节点的前一个节点temp
                if (temp.next.no == no) {
                    flag = true;
                    break;
                }
                //指针后移
                temp = temp.next;
            }
            if (flag) {
                temp.next = temp.next.next;
            } else {
                System.out.printf("要删除的%d节点不存在\n", no);
            }
        }

        //显示列表
        public void list() {
            //判断链表是否为空
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            HeroNode temp = head.next;
            while (true) {
                //判断是否到链表最后
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }

    //定义HeroNode，每个HeroNode对象就是一个节点
    static class HeroNode {
        public int no;
        public String name;
        public String nickname;
        //指向下一个节点
        public HeroNode next;

        // 构造器
        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode[no=" + no + ",name=" + name + ",nickname=" + nickname + "]";
        }
    }
}

