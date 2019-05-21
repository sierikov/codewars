import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class DivisibleNbTests {

    @Test
    public void test01() {
        assertTrue(DivisibleNb.isDivisible(12, 4, 3));
    }
    @Test
    public void test02() {
        assertFalse(DivisibleNb.isDivisible(14, 4, 3));
    }
    @Test
    public void test03() {
        assertFalse(DivisibleNb.isDivisible(3, 3, 4));
    }
    @Test
    public void test04() {
        assertFalse(DivisibleNb.isDivisible(1, 1000000, 1000000));
    }
    @Test
    public void test05(){
        assertFalse(DivisibleNb.isDivisible( -4074295112368257362L, 5906535141825899744L, -3849462976263470388L));
    }

    @Test
    public void test06(){
        assertFalse(DivisibleNb.isDivisible( -8634267278779220608L, 7147524223804375696L, -8093450051864258216L));
    }
    @Test
    public void test07(){
        assertFalse(DivisibleNb.isDivisible( 1087832029271815616L, 2323201921258131688L, -3921669006867723492L));
    }
    @Test
    public void test08(){
        assertFalse(DivisibleNb.isDivisible( 5424897706710159648L, -8251119498654879732L, -6359135171978353458L));
    }
        
    @Test
    public void test09() {
        assertFalse(DivisibleNb.isDivisible(-131361573408116576L, 3430963036136568485L, -7035601325870163798L));
    }
    @Test
    public void test10() {
        assertFalse(DivisibleNb.isDivisible(8215532615584363968L, 5579132242875868952L, -3131435590454323428L));
    }
    @Test
    public void test11() {
        assertFalse(DivisibleNb.isDivisible(643018937290151552L, 8818186686170455825L, -6496878960866775064L));
    }
    @Test
    public void test12() {
        assertFalse(DivisibleNb.isDivisible(-4895766632742843040L, 3499985607372071965L, -7028699068746613450L));
    }
    @Test
    public void test13() {
        assertFalse(DivisibleNb.isDivisible(-8982687756692829728L, 5672614486945849069L, -4966761773418280578L));
    }
    @Test
    public void test14() {
        assertFalse(DivisibleNb.isDivisible( 4180097505779380192L, -8057047062705294675L, 1038969701100425694L));
    }
    @Test
    public void test15() {
        assertFalse(DivisibleNb.isDivisible(-6355995289001488288L, 1709191203565986813L, 5704942342469464166L));
    }
    @Test
    public void test16() {
        assertFalse(DivisibleNb.isDivisible(-7845286466617628128L, -3088451546776112747L, 5225178067435254210L));
    }
    @Test
    public void test17() {
        assertFalse(DivisibleNb.isDivisible(3181689794049865088L, 1976983305680971889L, -5336324891544768296L));
    }
    @Test
    public void test18() {
        assertFalse(DivisibleNb.isDivisible(2638978852734883520L, 7473570328705103288L, 4436705847612420652L));
    }
    @Test
    public void test19() {
        assertFalse(DivisibleNb.isDivisible(-799443222584025312L, 2434170774507076788L, 3932765892192618002L));
    }
    @Test
    public void test20() {
        assertFalse(DivisibleNb.isDivisible(7321443924456354848L, -2353861797510366251L, -5769409401863902110L));
    }
    @Test
    public void test21() {
        assertFalse(DivisibleNb.isDivisible(-9179376461989262848L, -2259682153454554560L, -225968215345455456L));
    }
    @Test
    public void test22() {
        assertFalse(DivisibleNb.isDivisible(5832474553725063136L, -6376740974949779796L, 1207000309875977182L));
    }
    @Test
    public void test23() {
        assertFalse(DivisibleNb.isDivisible(7715635435515013664L, 3162108872039848340L, -8907161149650790974L));
    }
    @Test
    public void test24() {
        assertFalse(DivisibleNb.isDivisible(7227086576364553696L, -7020982405506974611L, -6236121462663562946L));
    }
    @Test
    public void test25() {
        assertFalse(DivisibleNb.isDivisible(47738145282682528L, 7231171415039426916L, 8101814770987763338L));
    }
    @Test
    public void test26() {
        assertFalse(DivisibleNb.isDivisible(1526165240194935136L, 7454010771018853789L, 4434749891843795702L));
    }
    @Test
    public void test27() {
        assertFalse(DivisibleNb.isDivisible(-3377830983036318944L, -1682031541690605516L, -7546900783652881198L));
    }
    @Test
    public void test28() {
        assertFalse(DivisibleNb.isDivisible(-3233648808501572096L, -8654756619378281279L, -865475661937828128L));
    }
    @Test
    public void test29() {
        assertFalse(DivisibleNb.isDivisible(6345524645040338752L, -4088831659718480119L, -408883165971848012L));
    }
    @Test
    public void test30() {
        assertFalse(DivisibleNb.isDivisible(-13896027146464576L, 5736923510896524089L, 4263041165831562732L));
    }
    @Test
    public void test31() {
        assertFalse(DivisibleNb.isDivisible(8522055222113687136L, -6374051394281391172L, 3051943675313771206L));
    }
    @Test
    public void test32() {
        assertFalse(DivisibleNb.isDivisible(8798897415047825024L, -710624121459624688L, -3760411226887872792L));
    }
    @Test
    public void test34() {
        assertFalse(DivisibleNb.isDivisible(328207914612827360L, 5349883989290382796L, -1309686008441916882L));
    }
    @Test
    public void test35() {
        assertFalse(DivisibleNb.isDivisible(-3181467851668477504L, -1036199135979403368L, 5430403308514925148L));
    }
    @Test
    public void test36() {
        assertFalse(DivisibleNb.isDivisible(7811987571303736352L, -8237882613376865835L, 1020886146033268578L));
    }
    @Test
    public void test37() {
        assertFalse(DivisibleNb.isDivisible(-7259651779303319456L, -173280348442689283L, 7361369594639551718L));
    }
    @Test
    public void test38() {
        assertFalse(DivisibleNb.isDivisible(3959015238557161504L, 1036976683366292052L, 5637720890449494690L));
    }
    @Test
    public void test39() {
        assertFalse(DivisibleNb.isDivisible(3157389930409930560L, -5254164671076812280L, -525416467107681228L));
    }
    @Test
    public void test40() {
        assertFalse(DivisibleNb.isDivisible(-1119746226095237920L, 9130018570260132813L, -2776346957715897042L));
    }
    @Test
    public void test41() {
        assertFalse(DivisibleNb.isDivisible(6421503574027187328L, -7519850078499469871L, -6286008229962812472L));
    }
    @Test
    public void test42() {
        assertFalse(DivisibleNb.isDivisible(-1549151934286649248L, -8708412354725195012L, 2818507579269390822L));
    }
    @Test
    public void test43() {
        assertFalse(DivisibleNb.isDivisible(923117017645086720L, -5440866384726672640L, -544086638472667264L));
    }
    @Test
    public void test44() {
        assertFalse(DivisibleNb.isDivisible(885968910316879552L, -2710785409924987208L, -3960427355734409044L));
    }
    @Test
    public void test45() {
        assertFalse(DivisibleNb.isDivisible(7476827575722584160L, -4788676631588760835L, 1365806744212079078L));
    }
    @Test
    public void test46() {
        assertFalse(DivisibleNb.isDivisible(7831330980238498048L, 7792357330085669281L, -8444136303846208880L));
    }
    @Test
    public void test47() {
        assertFalse(DivisibleNb.isDivisible(8267094252970968416L, -932516853506216164L, 7285445944133199030L));
    }
    @Test
    public void test48() {
        assertFalse(DivisibleNb.isDivisible(676030911815331296L, -4260521850115091092L, 3263296629730401214L));
    }
    @Test
    public void test49() {
        assertFalse(DivisibleNb.isDivisible(-1959114920576758368L, 8723350831944041156L, 8251032712678224762L));
    }
    @Test
    public void test50() {
        assertFalse(DivisibleNb.isDivisible(56660185198761056L, -1678597050522370436L, -7546557334536057690L));
    }
    @Test
    public void test51() {
        assertFalse(DivisibleNb.isDivisible(559750933471069152L, -4555786035272788180L, -455578603527278818L));
    }
    @Test
    public void test52() {
        assertFalse(DivisibleNb.isDivisible(7892470040138839456L, -4437772851723863099L, -443777285172386310L));
    }
    @Test
    public void test53() {
        assertFalse(DivisibleNb.isDivisible(6070665560715087264L, -3295896523633294652L, -5863612874476194950L));
    }
    @Test
    public void test54() {
        assertFalse(DivisibleNb.isDivisible(-7433241900259977568L, -6039518554003283356L, 1240722551970626826L));
    }
    @Test
    public void test55() {
        assertFalse(DivisibleNb.isDivisible( -7810551443014047520L , -561212873654300595L , 1788553120005525102L));
    }

}
