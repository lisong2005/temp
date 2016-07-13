/**
 * LS_Demon Org.
 * Copyright (c) 2005-2016 All Rights Reserved.
 */
package com.witon.ehealth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Test;

import com.witon.ehealth.common.base.BaseModel;

/**
 * 
 * @author lisong
 * @version $Id: StarTest.java, v 0.1 2016年6月17日 下午7:07:02 lisong Exp $
 */
public class StarTest {
    /**
    * Logger for this class
    */
    private static final Logger logger = LoggerFactory.getLogger(StarTest.class);

    @Test
    public void test_001() {
        logger.info("{}", new Stone(1));
        logger.info("{}", new Stone(2));
        logger.info("{}", new Stone(3));
        logger.info("{}", new Stone(4));
        logger.info("{}", new Stone(5));
        logger.info("{}", new Stone(6));
        logger.info("{}", new Stone(7));
        logger.info("{}", new Stone(8));
        logger.info("{}", new Stone(9));
    }

    public static class Stone extends BaseModel {

        /**  */
        private static final long serialVersionUID = 1L;

        private int               one              = 0;

        private int               two              = 0;

        private int               three            = 0;

        public Stone() {

        }

        public Stone(int level) {
            if (level == 1) {
                one = 1;
            }

            if (level == 2) {
                two = 1;
            }

            if (level == 3) {
                three = 1;
            }

            if (level > 3) {
                init(level);
            }
        }

        private void init(int level) {
            this.add(new Stone(level - 1)).add(new Stone(level - 2)).add(new Stone(level - 3));
        }

        public Stone add(Stone addStone) {
            //            Stone ret = new Stone();
            //            ret.one = this.one + addStone.one;
            //            ret.two = this.two + addStone.two;
            //            ret.three = this.three + addStone.three;
            //            return ret;

            this.one += addStone.one;
            this.two += addStone.two;
            this.three += addStone.three;
            return this;
        }

        /**
         * Getter method for property <tt>one</tt>.
         * 
         * @return property value of one
         */
        public int getOne() {
            return one;
        }

        /**
         * Setter method for property <tt>one</tt>.
         * 
         * @param one value to be assigned to property one
         */
        public void setOne(int one) {
            this.one = one;
        }

        /**
         * Getter method for property <tt>two</tt>.
         * 
         * @return property value of two
         */
        public int getTwo() {
            return two;
        }

        /**
         * Setter method for property <tt>two</tt>.
         * 
         * @param two value to be assigned to property two
         */
        public void setTwo(int two) {
            this.two = two;
        }

        /**
         * Getter method for property <tt>three</tt>.
         * 
         * @return property value of three
         */
        public int getThree() {
            return three;
        }

        /**
         * Setter method for property <tt>three</tt>.
         * 
         * @param three value to be assigned to property three
         */
        public void setThree(int three) {
            this.three = three;
        }

    }
}
