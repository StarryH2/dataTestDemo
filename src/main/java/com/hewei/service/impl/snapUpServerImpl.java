package com.hewei.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.hewei.entity.SnapUpModel;
import com.hewei.service.snapUpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @Author: HeWei
 * @Description:
 * @Date: 2022-06-18 22:53
 * @Version: 1.0
 */
@Service
@Transactional
public class snapUpServerImpl implements snapUpServer {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void goSnapUp() {
        String url = "http://localhost:8081/user/";
        String token = "http://localhost:8081/user/";
        SnapUpModel snapUpModel = new  SnapUpModel();
        snapUpModel.setSkuId(100014446427L);
        snapUpModel.setNum(1);
        snapUpModel.setName("之一");
        snapUpModel.setProvinceId(19L);
        snapUpModel.setCityId(1601L);
        snapUpModel.setCountyId(50258L);
        snapUpModel.setAddressDetail("沙娇南路5号");
        snapUpModel.setMobile("186****4462");
        snapUpModel.setMobileKey("a00a914fdd5eaf7e9bdb26161d568e3e");
        snapUpModel.setPostCode("");
        snapUpModel.setInvoiceTitle("4");
        snapUpModel.setInvoiceContent(1);
        snapUpModel.setInvoiceTaxpayerNO("");
        snapUpModel.setInvoiceEmail("1213770981@qq.com");
        snapUpModel.setInvoicePhone("186****4462");
        snapUpModel.setInvoicePhoneKey("a00a914fdd5eaf7e9bdb26161d568e3e");
        snapUpModel.setInvoice(true);
        snapUpModel.setPassword("");
        snapUpModel.setCodTimeType(3);
        snapUpModel.setPaymentType(4);
        snapUpModel.setAreaCode("86");
        snapUpModel.setOverseas("0");
        snapUpModel.setPhone("");
        snapUpModel.setEid("ff6dc80bd1783958c560ebc52607afe1");
        snapUpModel.setToken("a48b4c2680c45c4cf7b1f2c9d7102355");
        snapUpModel.setPru("");
        snapUpModel.setProvinceName("广东");
        snapUpModel.setCityName("广州市");
        snapUpModel.setCountyName("白云区");
        snapUpModel.setTownName("永平街道");
        snapUpModel.setSk("A6gt1XluvDQJ1CJCSQST");
        String s = testPost(url, snapUpModel, token);
        System.out.println(s);

        // SnapUpModel user = restTemplate.getForObject(url, SnapUpModel.class);
    }

    public String testPost(String url,SnapUpModel postEntity,String token) {

       /* MediaType type = MediaType.parseMediaType("application/json");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(type);
        headers.add("Accept", MediaType.ALL_VALUE);
        headers.add("Authorization", token);
        JSONObject param = JSONUtil.parseObj(postEntity);
        HttpEntity<String> formEntity = new HttpEntity<String>(param.toString(), headers);
        ResponseEntity<Integer> responsebody = restTemplate.exchange(
                url,
                HttpMethod.POST,
                formEntity,
                Integer.class);
        Integer contractId = responsebody.getBody();
        return responsebody.getBody().toString();*/
        return null;
    }

    public void a (String url){
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", "application/json, text/plain, */*");
        headers.add("Accept-Encoding", "gzip, deflate, br");
        headers.add("Accept-Language", "zh-CN,zh;q=0.9");
        headers.add("Cache-Control", "no-cache");
        headers.add("Connection", "keep-alive");
        headers.add("Content-Length", "863");
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.add("Cookie", "shshshfpa=600bdd89-f464-fcd5-1ca9-a4165917d20d-1612278667; shshshfpb=aGBD3q1LNZ0YoXsmq28wTYg%3D%3D; __jdu=1633164877678242827597; __jdv=76161171|www.google.com|-|referral|-|1655528541766; areaId=15; user-key=e983b4c2-eaec-44d2-b4d5-ca53dca93838; cn=42; ipLoc-djd=15-1213-3038-59931; TrackID=1PKMus2Pv5qoJyJtCGnjPFo5jrRKHZCCOAz2qOsF70Ia2BljVzm4tRo8GbpK9nt3V_gd-6-hraeFTRn0mrsB8EBbAtrgUK6cuE3ih8U8c-jA; pinId=4RDkiUCDK068DrNrnX5dEQ; pin=jd_rSYTNcTXnpxg; unick=jd_rSYTNcTXnpxg; ceshi3.com=000; _tp=e1s28Lo7KUJlbOrR8K6AZw%3D%3D; _pst=jd_rSYTNcTXnpxg; __jdc=122270672; shshshfp=2f4017d029988d8420c0745c8a922427; ip_cityCode=1213; mba_muid=1633164877678242827597; __jda=122270672.1633164877678242827597.1633164877.1655547955.1655556930.15; thor=A60542E54E672C81C448772CB5FA6C442DB602834E955651EDF292305813B8994F4BD74B0531F9AF13C3CBC34C9BFF95423667C7618206E44B995C3549C01CB5CB0825D9CE1FB1F4FF2AB53BBD4E6BD16A76943B0E195FD503818877ED8D354434F32E655DF24A47980D71EAF9FC6A499391AAEF4E41951F10122B782BC80934545144A00372FE34BBD701A2D65F51A333D6CB490090B907A44CE8168A681C84; 3AB9D23F7A4B3C9B=ZXTUWTOBLMNEUNJAP2JOLOOLGRYURZLUWGPTJY6O5YWCN6IFDJI6KOPZZLF5PY7IT2HFFQS5JYM3QIRAA7AMHIXA2E");
        headers.add("Host", "marathon.jd.com");
        headers.add("Origin", "https://marathon.jd.com");
        headers.add("Pragma", "no-cache");
        headers.add("Referer", "https://marathon.jd.com/seckill/seckill.action?skuId=100014446427&num=1&rid=1655556938");
        headers.add("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"102\", \"Google Chrome\";v=\"102\"");
        headers.add("sec-ch-ua-mobile", "?0");
        headers.add("sec-ch-ua-platform", "\"Windows\"");
        headers.add("sec-ch-ua-Sec-Fetch-Dest", "empty");
        headers.add("sec-ch-ua-Sec-Fetch-Mode", "cors");
        headers.add("sec-ch-ua-Sec-Fetch-Site", "same-origin");
        headers.add("sec-ch-ua-User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.0.0 Safari/537.36");

        JSONObject param = new JSONObject();
        param.put("skuId", "100014446427");
        param.put("num", "1");
        param.put("addressId", "4667426044");
        param.put("name", "之一");
        param.put("provinceId", "19");
        param.put("cityId", "1601");
        param.put("countyId", "50258");
        param.put("townId", "62860");
        param.put("addressDetail", "沙娇南路5号");
        param.put("mobile", "186****4462");
        param.put("mobileKey", "a00a914fdd5eaf7e9bdb26161d568e3e");
        param.put("postCode", "");
        param.put("invoiceTitle", "4");
        param.put("invoiceContent", "1");
        param.put("invoiceTaxpayerNO", "");
        param.put("invoiceEmail", "1213770981@qq.com");
        param.put("invoicePhone", "186****4462");
        param.put("invoicePhoneKey", "a00a914fdd5eaf7e9bdb26161d568e3e");
        param.put("invoice", true);
        param.put("password", "");
        param.put("codTimeType", "3");
        param.put("paymentType", "4");
        param.put("areaCode", "86");
        param.put("overseas", "0");
        param.put("phone", "");
        param.put("eid", "ZXTUWTOBLMNEUNJAP2JOLOOLGRYURZLUWGPTJY6O5YWCN6IFDJI6KOPZZLF5PY7IT2HFFQS5JYM3QIRAA7AMHIXA2E");
        param.put("fp", "ff6dc80bd1783958c560ebc52607afe1");
        param.put("token", "a48b4c2680c45c4cf7b1f2c9d7102355");
        param.put("pru", "");
        param.put("provinceName", "广东");
        param.put("cityName", "广州市");
        param.put("countyName", "永平街道");
        param.put("sk", "xebaovov8leexDpjuXp");





        HttpEntity<String> formEntity = new HttpEntity<String>(param.toJSONString(), headers);
        JSONObject  result = restTemplate.postForObject(url, formEntity, JSONObject.class);
        byte[] data = result.getObject( "result" , byte[].class );
        System.out.println(  new String( data, StandardCharsets.UTF_8 ) );
    }
}
