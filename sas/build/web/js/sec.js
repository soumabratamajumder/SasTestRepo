/*
 * A JavaScript implementation of the RSA Data Security, Inc. MD5 Message
 * Digest Algorithm, as defined in RFC 1321.
 * Version 2.1 Copyright (C) Paul Johnston 1999 - 2002.
 * Other contributors: Greg Holt, Andrew Kepert, Ydnar, Lostinet
 * Distributed under the BSD License
 * See http://pajhome.org.uk/crypt/md5 for more info.
 */

/*
 * Configurable variables. You may need to tweak these to be compatible with
 * the server-side, but the defaults work in most cases.
 */
var hexcase = 0;  /* hex output format. 0 - lowercase; 1 - uppercase        */
var b64pad = ""; /* base-64 pad character. "=" for strict RFC compliance   */
var chrsz = 8;  /* bits per input character. 8 - ASCII; 16 - Unicode      */

/*
 * These are the functions you'll usually want to call
 * They take string arguments and return either hex or base-64 encoded strings
 */
function hex_md5(s) {
    return binl2hex(core_md5(str2binl(s), s.length * chrsz));
}
function b64_md5(s) {
    return binl2b64(core_md5(str2binl(s), s.length * chrsz));
}
function str_md5(s) {
    return binl2str(core_md5(str2binl(s), s.length * chrsz));
}
function hex_hmac_md5(key, data) {
    return binl2hex(core_hmac_md5(key, data));
}
function b64_hmac_md5(key, data) {
    return binl2b64(core_hmac_md5(key, data));
}
function str_hmac_md5(key, data) {
    return binl2str(core_hmac_md5(key, data));
}

/*
 * Perform a simple self-test to see if the VM is working
 */
function md5_vm_test()
{
    return hex_md5("abc") == "900150983cd24fb0d6963f7d28e17f72";
}

/*
 * Calculate the MD5 of an array of little-endian words, and a bit length
 */
function core_md5(x, len)
{
    /* append padding */
    x[len >> 5] |= 0x80 << ((len) % 32);
    x[(((len + 64) >>> 9) << 4) + 14] = len;

    var a = 1732584193;
    var b = -271733879;
    var c = -1732584194;
    var d = 271733878;

    for (var i = 0; i < x.length; i += 16)
    {
        var olda = a;
        var oldb = b;
        var oldc = c;
        var oldd = d;

        a = md5_ff(a, b, c, d, x[i + 0], 7, -680876936);
        d = md5_ff(d, a, b, c, x[i + 1], 12, -389564586);
        c = md5_ff(c, d, a, b, x[i + 2], 17, 606105819);
        b = md5_ff(b, c, d, a, x[i + 3], 22, -1044525330);
        a = md5_ff(a, b, c, d, x[i + 4], 7, -176418897);
        d = md5_ff(d, a, b, c, x[i + 5], 12, 1200080426);
        c = md5_ff(c, d, a, b, x[i + 6], 17, -1473231341);
        b = md5_ff(b, c, d, a, x[i + 7], 22, -45705983);
        a = md5_ff(a, b, c, d, x[i + 8], 7, 1770035416);
        d = md5_ff(d, a, b, c, x[i + 9], 12, -1958414417);
        c = md5_ff(c, d, a, b, x[i + 10], 17, -42063);
        b = md5_ff(b, c, d, a, x[i + 11], 22, -1990404162);
        a = md5_ff(a, b, c, d, x[i + 12], 7, 1804603682);
        d = md5_ff(d, a, b, c, x[i + 13], 12, -40341101);
        c = md5_ff(c, d, a, b, x[i + 14], 17, -1502002290);
        b = md5_ff(b, c, d, a, x[i + 15], 22, 1236535329);

        a = md5_gg(a, b, c, d, x[i + 1], 5, -165796510);
        d = md5_gg(d, a, b, c, x[i + 6], 9, -1069501632);
        c = md5_gg(c, d, a, b, x[i + 11], 14, 643717713);
        b = md5_gg(b, c, d, a, x[i + 0], 20, -373897302);
        a = md5_gg(a, b, c, d, x[i + 5], 5, -701558691);
        d = md5_gg(d, a, b, c, x[i + 10], 9, 38016083);
        c = md5_gg(c, d, a, b, x[i + 15], 14, -660478335);
        b = md5_gg(b, c, d, a, x[i + 4], 20, -405537848);
        a = md5_gg(a, b, c, d, x[i + 9], 5, 568446438);
        d = md5_gg(d, a, b, c, x[i + 14], 9, -1019803690);
        c = md5_gg(c, d, a, b, x[i + 3], 14, -187363961);
        b = md5_gg(b, c, d, a, x[i + 8], 20, 1163531501);
        a = md5_gg(a, b, c, d, x[i + 13], 5, -1444681467);
        d = md5_gg(d, a, b, c, x[i + 2], 9, -51403784);
        c = md5_gg(c, d, a, b, x[i + 7], 14, 1735328473);
        b = md5_gg(b, c, d, a, x[i + 12], 20, -1926607734);

        a = md5_hh(a, b, c, d, x[i + 5], 4, -378558);
        d = md5_hh(d, a, b, c, x[i + 8], 11, -2022574463);
        c = md5_hh(c, d, a, b, x[i + 11], 16, 1839030562);
        b = md5_hh(b, c, d, a, x[i + 14], 23, -35309556);
        a = md5_hh(a, b, c, d, x[i + 1], 4, -1530992060);
        d = md5_hh(d, a, b, c, x[i + 4], 11, 1272893353);
        c = md5_hh(c, d, a, b, x[i + 7], 16, -155497632);
        b = md5_hh(b, c, d, a, x[i + 10], 23, -1094730640);
        a = md5_hh(a, b, c, d, x[i + 13], 4, 681279174);
        d = md5_hh(d, a, b, c, x[i + 0], 11, -358537222);
        c = md5_hh(c, d, a, b, x[i + 3], 16, -722521979);
        b = md5_hh(b, c, d, a, x[i + 6], 23, 76029189);
        a = md5_hh(a, b, c, d, x[i + 9], 4, -640364487);
        d = md5_hh(d, a, b, c, x[i + 12], 11, -421815835);
        c = md5_hh(c, d, a, b, x[i + 15], 16, 530742520);
        b = md5_hh(b, c, d, a, x[i + 2], 23, -995338651);

        a = md5_ii(a, b, c, d, x[i + 0], 6, -198630844);
        d = md5_ii(d, a, b, c, x[i + 7], 10, 1126891415);
        c = md5_ii(c, d, a, b, x[i + 14], 15, -1416354905);
        b = md5_ii(b, c, d, a, x[i + 5], 21, -57434055);
        a = md5_ii(a, b, c, d, x[i + 12], 6, 1700485571);
        d = md5_ii(d, a, b, c, x[i + 3], 10, -1894986606);
        c = md5_ii(c, d, a, b, x[i + 10], 15, -1051523);
        b = md5_ii(b, c, d, a, x[i + 1], 21, -2054922799);
        a = md5_ii(a, b, c, d, x[i + 8], 6, 1873313359);
        d = md5_ii(d, a, b, c, x[i + 15], 10, -30611744);
        c = md5_ii(c, d, a, b, x[i + 6], 15, -1560198380);
        b = md5_ii(b, c, d, a, x[i + 13], 21, 1309151649);
        a = md5_ii(a, b, c, d, x[i + 4], 6, -145523070);
        d = md5_ii(d, a, b, c, x[i + 11], 10, -1120210379);
        c = md5_ii(c, d, a, b, x[i + 2], 15, 718787259);
        b = md5_ii(b, c, d, a, x[i + 9], 21, -343485551);

        a = safe_add(a, olda);
        b = safe_add(b, oldb);
        c = safe_add(c, oldc);
        d = safe_add(d, oldd);
    }
    return Array(a, b, c, d);

}

/*
 * These functions implement the four basic operations the algorithm uses.
 */
function md5_cmn(q, a, b, x, s, t)
{
    return safe_add(bit_rol(safe_add(safe_add(a, q), safe_add(x, t)), s), b);
}
function md5_ff(a, b, c, d, x, s, t)
{
    return md5_cmn((b & c) | ((~b) & d), a, b, x, s, t);
}
function md5_gg(a, b, c, d, x, s, t)
{
    return md5_cmn((b & d) | (c & (~d)), a, b, x, s, t);
}
function md5_hh(a, b, c, d, x, s, t)
{
    return md5_cmn(b ^ c ^ d, a, b, x, s, t);
}
function md5_ii(a, b, c, d, x, s, t)
{
    return md5_cmn(c ^ (b | (~d)), a, b, x, s, t);
}

/*
 * Calculate the HMAC-MD5, of a key and some data
 */
function core_hmac_md5(key, data)
{
    var bkey = str2binl(key);
    if (bkey.length > 16)
        bkey = core_md5(bkey, key.length * chrsz);

    var ipad = Array(16), opad = Array(16);
    for (var i = 0; i < 16; i++)
    {
        ipad[i] = bkey[i] ^ 0x36363636;
        opad[i] = bkey[i] ^ 0x5C5C5C5C;
    }

    var hash = core_md5(ipad.concat(str2binl(data)), 512 + data.length * chrsz);
    return core_md5(opad.concat(hash), 512 + 128);
}

/*
 * Add integers, wrapping at 2^32. This uses 16-bit operations internally
 * to work around bugs in some JS interpreters.
 */
function safe_add(x, y)
{
    var lsw = (x & 0xFFFF) + (y & 0xFFFF);
    var msw = (x >> 16) + (y >> 16) + (lsw >> 16);
    return (msw << 16) | (lsw & 0xFFFF);
}

/*
 * Bitwise rotate a 32-bit number to the left.
 */
function bit_rol(num, cnt)
{
    return (num << cnt) | (num >>> (32 - cnt));
}

/*
 * Convert a string to an array of little-endian words
 * If chrsz is ASCII, characters >255 have their hi-byte silently ignored.
 */
function str2binl(str)
{
    var bin = Array();
    var mask = (1 << chrsz) - 1;
    for (var i = 0; i < str.length * chrsz; i += chrsz)
        bin[i >> 5] |= (str.charCodeAt(i / chrsz) & mask) << (i % 32);
    return bin;
}

/*
 * Convert an array of little-endian words to a string
 */
function binl2str(bin)
{
    var str = "";
    var mask = (1 << chrsz) - 1;
    for (var i = 0; i < bin.length * 32; i += chrsz)
        str += String.fromCharCode((bin[i >> 5] >>> (i % 32)) & mask);
    return str;
}

/*
 * Convert an array of little-endian words to a hex string.
 */
function binl2hex(binarray)
{
    var hex_tab = hexcase ? "0123456789ABCDEF" : "0123456789abcdef";
    var str = "";
    for (var i = 0; i < binarray.length * 4; i++)
    {
        str += hex_tab.charAt((binarray[i >> 2] >> ((i % 4) * 8 + 4)) & 0xF) +
                hex_tab.charAt((binarray[i >> 2] >> ((i % 4) * 8)) & 0xF);
    }
    return str;
}

/*
 * Convert an array of little-endian words to a base-64 string
 */
function binl2b64(binarray)
{
    var tab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    var str = "";
    for (var i = 0; i < binarray.length * 4; i += 3)
    {
        var triplet = (((binarray[i >> 2] >> 8 * (i % 4)) & 0xFF) << 16)
                | (((binarray[i + 1 >> 2] >> 8 * ((i + 1) % 4)) & 0xFF) << 8)
                | ((binarray[i + 2 >> 2] >> 8 * ((i + 2) % 4)) & 0xFF);
        for (var j = 0; j < 4; j++)
        {
            if (i * 8 + j * 6 > binarray.length * 32)
                str += b64pad;
            else
                str += tab.charAt((triplet >> 6 * (3 - j)) & 0x3F);
        }
    }
    return str;
}


function comHash(rval)
{
    var password = document.forms[0].inputPassword.value;
    var username = document.forms[0].inputUser.value;
    var key = document.forms[0].inputCap.value;
    var veri = true;
    //alert ("sss");
    if (username.length == 0)
    {

        document.forms[0].inputUser.focus();
        // alert("Please Enter Username");  
        veri = false;
        return false;

    }

    if (password.length == 0) {
        document.forms[0].inputPassword.focus();
        //  alert("Please Enter Password"); 
        veri = false;
        return false;
    }

    if (key.length == 0) {
        document.forms[0].inputCap.focus();
        alert("Please complete word verification!!");
        veri = false;
        return false;
    }



    if (veri == true)
    {
        //alert(rval);
        //alert(password);
       // alert(rval+hex_md5(password));
        var hash = hex_md5(rval + hex_md5(password));
        //alert(hash);
        //alert(hex_md5(rval+hex_md5(password)));
        document.forms[0].hash.value = hash;
        //  document.forms[0].txtwd.value="";
        document.forms[0].inputNewPwd.value = hash;
        document.forms[0].submit();

    }

    return veri;

}

function comHashsha(rval)
{
    var password = document.forms[0].inputPassword.value;
    var username = document.forms[0].inputUser.value;
    var key = document.forms[0].inputCap.value;
    var veri = true;
    //alert ("sss");
    if (username.length == 0)
    {

        document.forms[0].inputUser.focus();
        // alert("Please Enter Username");  
        veri = false;
        return false;

    }

    if (password.length == 0) {
        document.forms[0].inputPassword.focus();
        //  alert("Please Enter Password"); 
        veri = false;
        return false;
    }

    if (key.length == 0) {
        document.forms[0].inputCap.focus();
        alert("Please complete word verification!!");
        veri = false;
        return false;
    }



    if (veri == true)
    {
        //alert(rval);
        //alert(password);
      //  alert(SHA512(rval+hex_md5(password)));
        var hash = SHA512(hex_md5(rval + hex_md5(password)));
       // alert(hash);
        //alert(hex_md5(rval+hex_md5(password)));
        document.forms[0].hash.value = hash;
        //  document.forms[0].txtwd.value="";
        //document.forms[0].inputNewPwd.value = hash;
         
        document.forms[0].submit();

    }

    return veri;

}

function comHash_verify(rval)
{
    var password = document.forms[0].inputOldPwd.value;
    var username = document.forms[0].inputUser.value;

    var veri = true;
    //alert ("sss");
    if (username.length == 0)
    {

        document.forms[0].inputUser.focus();
        // alert("Please Enter Username");  
        veri = false;
        return false;

    }

    if (password.length == 0) {
        document.forms[0].inputOldPwd.focus();
        //  alert("Please Enter Password"); 
        veri = false;
        return false;
    }




    if (veri == true)
    {
        //alert(rval);
        //alert(password);
        //alert(rval+hex_md5(password));
        var hash = hex_md5(rval + hex_md5(password));
        //alert(hash);
        //alert(hex_md5(rval+hex_md5(password)));
        document.forms[0].hash.value = hash;
        //  document.forms[0].txtwd.value="";
        //   document.forms[0].submit();
    }

    return veri;

}


function comHashIns(rval)
{

    var password = document.forms[0].txtpwd.value;
    var repassword = document.forms[0].txtpwd_r.value;

    if (password.length == 0)
    {
        return false;
    }
    if (repassword.length == 0)
    {
        return false;
    }

    if (password.length < 5)
    {
        return false;
    }
    if (repassword.length < 5)
    {
        return false;
    }

    if (repassword != password)
    {
        return false;
    }



    var hash_ins = rval + hex_md5(password);
    var hash_ins_r = rval + hex_md5(repassword);

    document.forms[0].hash.value = hash_ins;
    document.forms[0].hash1.value = hash_ins_r;

    document.forms[0].txtpwd.value = "";
    document.forms[0].txtpwd_r.value = "";



    return true;
}


function comHashIns_chpass(rval)
{



    var password = document.forms[0].inputNewPwd.value;
    var repassword = document.forms[0].inputNewPwdConfirm.value;
    var oldpassword = document.forms[0].inputOldPwd.value;



    if (oldpassword.length == 0)
    {
        return false;
    }

    if (password.length == 0)
    {
        return false;
    }
    if (repassword.length == 0)
    {
        return false;
    }


    //alert(hex_md5(rval));
    //alert(hex_md5(password));

    var hash_ins = hex_md5(rval) + hex_md5(password);
    var hash_ins_r = hex_md5(rval) + hex_md5(repassword);
    var hash_old = hex_md5(rval + hex_md5(oldpassword));
    var hash = hex_md5(rval);

    document.forms[0].inputNewPwd.value = hash_ins;
    document.forms[0].inputNewPwdConfirm.value = hash_ins_r;
    document.forms[0].inputOldPwd.value = hash_old;
    document.forms[0].hash.value = hash;


    return true;
}



function comHash_register(rval)
{
    var password = document.forms[0].pwd.value;
    var repassword = document.forms[0].pwdConfirm.value;

    if (password.length == 0)
    {
        return false;
    }
    if (repassword.length == 0)
    {
        return false;
    }

    if (password.length < 5)
    {
        return false;
    }
    if (repassword.length < 5)
    {
        return false;
    }

    if (repassword != password)
    {
        return false;
    }

    var hash_ins = hex_md5(rval) + hex_md5(password);
    var hash_ins_r = hex_md5(rval) + hex_md5(repassword);
    var hash = hex_md5(rval);

    document.forms[0].pwd.value = hash_ins;
    document.forms[0].pwdConfirm.value = hash_ins_r;
    document.forms[0].hash.value = hash;


    return true;
}



function comHashregisteruser(rval)
{

    var password = document.forms[0].inputNewPwd.value;
    var repassword = document.forms[0].inputNewPwdConfirm.value;

    if (password.length == 0)
    {
        return false;
    }
    if (repassword.length == 0)
    {
        return false;
    }

    if (password.length < 5)
    {
        return false;
    }
    if (repassword.length < 5)
    {
        return false;
    }

    if (repassword != password)
    {
        return false;
    }

    var hash_ins = hex_md5(rval) + hex_md5(password);
    var hash_ins_r = hex_md5(rval) + hex_md5(repassword);
    var hash = hex_md5(rval);

    document.forms[0].inputNewPwd.value = hash_ins;
    document.forms[0].inputNewPwdConfirm.value = hash_ins_r;
    document.forms[0].hash.value = hash;

   // alert(hash_ins);
    return true;
}

function SHA512(str) {
     
 function int64(msint_32, lsint_32) {
 this.highOrder = msint_32;
 this.lowOrder = lsint_32;
 }

 var H = [new int64(0x6a09e667, 0xf3bcc908), new int64(0xbb67ae85, 0x84caa73b),
 new int64(0x3c6ef372, 0xfe94f82b), new int64(0xa54ff53a, 0x5f1d36f1),
 new int64(0x510e527f, 0xade682d1), new int64(0x9b05688c, 0x2b3e6c1f),
 new int64(0x1f83d9ab, 0xfb41bd6b), new int64(0x5be0cd19, 0x137e2179)];

 var K = [new int64(0x428a2f98, 0xd728ae22), new int64(0x71374491, 0x23ef65cd),
 new int64(0xb5c0fbcf, 0xec4d3b2f), new int64(0xe9b5dba5, 0x8189dbbc),
 new int64(0x3956c25b, 0xf348b538), new int64(0x59f111f1, 0xb605d019),
 new int64(0x923f82a4, 0xaf194f9b), new int64(0xab1c5ed5, 0xda6d8118),
 new int64(0xd807aa98, 0xa3030242), new int64(0x12835b01, 0x45706fbe),
 new int64(0x243185be, 0x4ee4b28c), new int64(0x550c7dc3, 0xd5ffb4e2),
 new int64(0x72be5d74, 0xf27b896f), new int64(0x80deb1fe, 0x3b1696b1),
 new int64(0x9bdc06a7, 0x25c71235), new int64(0xc19bf174, 0xcf692694),
 new int64(0xe49b69c1, 0x9ef14ad2), new int64(0xefbe4786, 0x384f25e3),
 new int64(0x0fc19dc6, 0x8b8cd5b5), new int64(0x240ca1cc, 0x77ac9c65),
 new int64(0x2de92c6f, 0x592b0275), new int64(0x4a7484aa, 0x6ea6e483),
 new int64(0x5cb0a9dc, 0xbd41fbd4), new int64(0x76f988da, 0x831153b5),
 new int64(0x983e5152, 0xee66dfab), new int64(0xa831c66d, 0x2db43210),
 new int64(0xb00327c8, 0x98fb213f), new int64(0xbf597fc7, 0xbeef0ee4),
 new int64(0xc6e00bf3, 0x3da88fc2), new int64(0xd5a79147, 0x930aa725),
 new int64(0x06ca6351, 0xe003826f), new int64(0x14292967, 0x0a0e6e70),
 new int64(0x27b70a85, 0x46d22ffc), new int64(0x2e1b2138, 0x5c26c926),
 new int64(0x4d2c6dfc, 0x5ac42aed), new int64(0x53380d13, 0x9d95b3df),
 new int64(0x650a7354, 0x8baf63de), new int64(0x766a0abb, 0x3c77b2a8),
 new int64(0x81c2c92e, 0x47edaee6), new int64(0x92722c85, 0x1482353b),
 new int64(0xa2bfe8a1, 0x4cf10364), new int64(0xa81a664b, 0xbc423001),
 new int64(0xc24b8b70, 0xd0f89791), new int64(0xc76c51a3, 0x0654be30),
 new int64(0xd192e819, 0xd6ef5218), new int64(0xd6990624, 0x5565a910),
 new int64(0xf40e3585, 0x5771202a), new int64(0x106aa070, 0x32bbd1b8),
 new int64(0x19a4c116, 0xb8d2d0c8), new int64(0x1e376c08, 0x5141ab53),
 new int64(0x2748774c, 0xdf8eeb99), new int64(0x34b0bcb5, 0xe19b48a8),
 new int64(0x391c0cb3, 0xc5c95a63), new int64(0x4ed8aa4a, 0xe3418acb),
 new int64(0x5b9cca4f, 0x7763e373), new int64(0x682e6ff3, 0xd6b2b8a3),
 new int64(0x748f82ee, 0x5defb2fc), new int64(0x78a5636f, 0x43172f60),
 new int64(0x84c87814, 0xa1f0ab72), new int64(0x8cc70208, 0x1a6439ec),
 new int64(0x90befffa, 0x23631e28), new int64(0xa4506ceb, 0xde82bde9),
 new int64(0xbef9a3f7, 0xb2c67915), new int64(0xc67178f2, 0xe372532b),
 new int64(0xca273ece, 0xea26619c), new int64(0xd186b8c7, 0x21c0c207),
 new int64(0xeada7dd6, 0xcde0eb1e), new int64(0xf57d4f7f, 0xee6ed178),
 new int64(0x06f067aa, 0x72176fba), new int64(0x0a637dc5, 0xa2c898a6),
 new int64(0x113f9804, 0xbef90dae), new int64(0x1b710b35, 0x131c471b),
 new int64(0x28db77f5, 0x23047d84), new int64(0x32caab7b, 0x40c72493),
 new int64(0x3c9ebe0a, 0x15c9bebc), new int64(0x431d67c4, 0x9c100d4c),
 new int64(0x4cc5d4be, 0xcb3e42b6), new int64(0x597f299c, 0xfc657e2a),
 new int64(0x5fcb6fab, 0x3ad6faec), new int64(0x6c44198c, 0x4a475817)];

 var W = new Array(64);
 var a, b, c, d, e, f, g, h, i, j;
 var T1, T2;
 var charsize = 8;

 function utf8_encode(str) {
 return unescape(encodeURIComponent(str));
 }

 function str2binb(str) {
 var bin = [];
 var mask = (1 << charsize) - 1;
 var len = str.length * charsize;

 for (var i = 0; i < len; i += charsize) {
 bin[i >> 5] |= (str.charCodeAt(i / charsize) & mask) << (32 - charsize - (i % 32));
 }

 return bin;
 }

 function binb2hex(binarray) {
 var hex_tab = '0123456789abcdef';
 var str = '';
 var length = binarray.length * 4;
 var srcByte;

 for (var i = 0; i < length; i += 1) {
 srcByte = binarray[i >> 2] >> ((3 - (i % 4)) * 8);
 str += hex_tab.charAt((srcByte >> 4) & 0xF) + hex_tab.charAt(srcByte & 0xF);
 }

 return str;
 }

 function safe_add_2(x, y) {
 var lsw, msw, lowOrder, highOrder;

 lsw = (x.lowOrder & 0xFFFF) + (y.lowOrder & 0xFFFF);
 msw = (x.lowOrder >>> 16) + (y.lowOrder >>> 16) + (lsw >>> 16);
 lowOrder = ((msw & 0xFFFF) << 16) | (lsw & 0xFFFF);

 lsw = (x.highOrder & 0xFFFF) + (y.highOrder & 0xFFFF) + (msw >>> 16);
 msw = (x.highOrder >>> 16) + (y.highOrder >>> 16) + (lsw >>> 16);
 highOrder = ((msw & 0xFFFF) << 16) | (lsw & 0xFFFF);

 return new int64(highOrder, lowOrder);
 }

 function safe_add_4(a, b, c, d) {
 var lsw, msw, lowOrder, highOrder;

 lsw = (a.lowOrder & 0xFFFF) + (b.lowOrder & 0xFFFF) + (c.lowOrder & 0xFFFF) + (d.lowOrder & 0xFFFF);
 msw = (a.lowOrder >>> 16) + (b.lowOrder >>> 16) + (c.lowOrder >>> 16) + (d.lowOrder >>> 16) + (lsw >>> 16);
 lowOrder = ((msw & 0xFFFF) << 16) | (lsw & 0xFFFF);

 lsw = (a.highOrder & 0xFFFF) + (b.highOrder & 0xFFFF) + (c.highOrder & 0xFFFF) + (d.highOrder & 0xFFFF) + (msw >>> 16);
 msw = (a.highOrder >>> 16) + (b.highOrder >>> 16) + (c.highOrder >>> 16) + (d.highOrder >>> 16) + (lsw >>> 16);
 highOrder = ((msw & 0xFFFF) << 16) | (lsw & 0xFFFF);

 return new int64(highOrder, lowOrder);
 }

 function safe_add_5(a, b, c, d, e) {
 var lsw, msw, lowOrder, highOrder;

 lsw = (a.lowOrder & 0xFFFF) + (b.lowOrder & 0xFFFF) + (c.lowOrder & 0xFFFF) + (d.lowOrder & 0xFFFF) + (e.lowOrder & 0xFFFF);
 msw = (a.lowOrder >>> 16) + (b.lowOrder >>> 16) + (c.lowOrder >>> 16) + (d.lowOrder >>> 16) + (e.lowOrder >>> 16) + (lsw >>> 16);
 lowOrder = ((msw & 0xFFFF) << 16) | (lsw & 0xFFFF);

 lsw = (a.highOrder & 0xFFFF) + (b.highOrder & 0xFFFF) + (c.highOrder & 0xFFFF) + (d.highOrder & 0xFFFF) + (e.highOrder & 0xFFFF) + (msw >>> 16);
 msw = (a.highOrder >>> 16) + (b.highOrder >>> 16) + (c.highOrder >>> 16) + (d.highOrder >>> 16) + (e.highOrder >>> 16) + (lsw >>> 16);
 highOrder = ((msw & 0xFFFF) << 16) | (lsw & 0xFFFF);

 return new int64(highOrder, lowOrder);
 }

 function maj(x, y, z) {
 return new int64(
 (x.highOrder & y.highOrder) ^ (x.highOrder & z.highOrder) ^ (y.highOrder & z.highOrder),
 (x.lowOrder & y.lowOrder) ^ (x.lowOrder & z.lowOrder) ^ (y.lowOrder & z.lowOrder)
 );
 }

 function ch(x, y, z) {
 return new int64(
 (x.highOrder & y.highOrder) ^ (~x.highOrder & z.highOrder),
 (x.lowOrder & y.lowOrder) ^ (~x.lowOrder & z.lowOrder)
 );
 }

 function rotr(x, n) {
 if (n <= 32) {
 return new int64(
 (x.highOrder >>> n) | (x.lowOrder << (32 - n)),
 (x.lowOrder >>> n) | (x.highOrder << (32 - n))
 );
 } else {
 return new int64(
 (x.lowOrder >>> n) | (x.highOrder << (32 - n)),
 (x.highOrder >>> n) | (x.lowOrder << (32 - n))
 );
 }
 }

 function sigma0(x) {
 var rotr28 = rotr(x, 28);
 var rotr34 = rotr(x, 34);
 var rotr39 = rotr(x, 39);

 return new int64(
 rotr28.highOrder ^ rotr34.highOrder ^ rotr39.highOrder,
 rotr28.lowOrder ^ rotr34.lowOrder ^ rotr39.lowOrder
 );
 }

 function sigma1(x) {
 var rotr14 = rotr(x, 14);
 var rotr18 = rotr(x, 18);
 var rotr41 = rotr(x, 41);

 return new int64(
 rotr14.highOrder ^ rotr18.highOrder ^ rotr41.highOrder,
 rotr14.lowOrder ^ rotr18.lowOrder ^ rotr41.lowOrder
 );
 }

 function gamma0(x) {
 var rotr1 = rotr(x, 1), rotr8 = rotr(x, 8), shr7 = shr(x, 7);

 return new int64(
 rotr1.highOrder ^ rotr8.highOrder ^ shr7.highOrder,
 rotr1.lowOrder ^ rotr8.lowOrder ^ shr7.lowOrder
 );
 }

 function gamma1(x) {
 var rotr19 = rotr(x, 19);
 var rotr61 = rotr(x, 61);
 var shr6 = shr(x, 6);

 return new int64(
 rotr19.highOrder ^ rotr61.highOrder ^ shr6.highOrder,
 rotr19.lowOrder ^ rotr61.lowOrder ^ shr6.lowOrder
 );
 }

 function shr(x, n) {
 if (n <= 32) {
 return new int64(
 x.highOrder >>> n,
 x.lowOrder >>> n | (x.highOrder << (32 - n))
 );
 } else {
 return new int64(
 0,
 x.highOrder << (32 - n)
 );
 }
 }

 str = utf8_encode(str);
 strlen = str.length*charsize;
 str = str2binb(str);

 str[strlen >> 5] |= 0x80 << (24 - strlen % 32);
 str[(((strlen + 128) >> 10) << 5) + 31] = strlen;

 for (var i = 0; i < str.length; i += 32) {
 a = H[0];
 b = H[1];
 c = H[2];
 d = H[3];
 e = H[4];
 f = H[5];
 g = H[6];
 h = H[7];

 for (var j = 0; j < 80; j++) {
 if (j < 16) {
 W[j] = new int64(str[j*2 + i], str[j*2 + i + 1]);
 } else {
 W[j] = safe_add_4(gamma1(W[j - 2]), W[j - 7], gamma0(W[j - 15]), W[j - 16]);
 }

 T1 = safe_add_5(h, sigma1(e), ch(e, f, g), K[j], W[j]);
 T2 = safe_add_2(sigma0(a), maj(a, b, c));
 h = g;
 g = f;
 f = e;
 e = safe_add_2(d, T1);
 d = c;
 c = b;
 b = a;
 a = safe_add_2(T1, T2);
 }

 H[0] = safe_add_2(a, H[0]);
 H[1] = safe_add_2(b, H[1]);
 H[2] = safe_add_2(c, H[2]);
 H[3] = safe_add_2(d, H[3]);
 H[4] = safe_add_2(e, H[4]);
 H[5] = safe_add_2(f, H[5]);
 H[6] = safe_add_2(g, H[6]);
 H[7] = safe_add_2(h, H[7]);
 }

 var binarray = [];
 for (var i = 0; i < H.length; i++) {
 binarray.push(H[i].highOrder);
 binarray.push(H[i].lowOrder);
 }
 //alert(binb2hex(binarray));
 
 return binb2hex(binarray);


}