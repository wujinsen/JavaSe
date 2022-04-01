package cn.test;



//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class UserServiceTest {
//
//    @Test
//    public void test() {
//        Assert.assertEquals(1, 1);
//        String testStr3 = "abc 24def 23 def cc bb 5.2,6, 7,100.2 aaa";    //  --> {23, 5.2, 6, 7, 100.2}
//        log.info("testStr3: {}", getDigit(testStr3));
//
//        String testStr4 = "12.3";// --> {12.3}
//        log.info("testStr4: {}", getDigit(testStr4));
//
//        String testStr5 = " hij123 123.4kkk 1a3n";// --> {}
//        log.info("testStr5: {}", getDigit(testStr5));
//
//        String testStr6 = "12...3 , , 12.3 ";// --> {12.3}
//        log.info("testStr6: {}", getDigit(testStr6));
//    }
//
//    // 判断一个字符串是否都为数字
//    public static boolean isDigit(String strNum) {
//        if (StringUtils.isNotEmpty(strNum)) {
//            String reg = "^[0-9]+(.[0-9]+)?$";
//            return strNum.matches(reg);
//        }
//        return false;
//    }
//
//    public static List getDigit(String content) {
//        String arr[] = content.replaceAll(",", " ").split(" ");
//        List list = new ArrayList<>();
//        for (String str : arr) {
//            if (isDigit(str)) {
//                list.add(str);
//            }
//        }
//        return list;
//    }
//}
