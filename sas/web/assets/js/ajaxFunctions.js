/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function getXMLObject() {  //XML OBJECT
    var xmlHttp = false;
    try {
        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); // For Old Microsoft Browsers
    } catch (e) {
        try {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); // For Microsoft IE 6.0+
        } catch (e2) {
            xmlHttp = false; // No Browser accepts the XMLHTTP Object then false
        }
    }
    if (!xmlHttp && typeof XMLHttpRequest !== 'undefined') {
        xmlHttp = new XMLHttpRequest(); //For Mozilla, Opera Browsers
    }
    return xmlHttp; // Mandatory Statement returning the ajax object created
}

var xmlhttp = new getXMLObject();

function dependentDropDown(sourceDD, targetDD, category) {
    var i;

//    var sources = sourceDD.split("~");
//    if (sources.length === 1) {
//        url += sources.length + "&keyword=" + sources[0].value;
//    } else if (sources.length > 1) {
//        url += sources.length;
//        for (j = 0; j < sources.length; j++) {
//            url += "&keyword_" + (j + 1) + "=" + sources[j].value;
//        }
//    }

    var sourceOBJ = document.getElementById(sourceDD);
    var targetOBJ = document.getElementById(targetDD);
    var url = "../sas/AjaxServlet?category=" + category + "&value=" + sourceOBJ.value;
    if (xmlhttp) {
        xmlhttp.open("POST", url, false);
        xmlhttp.send("");
        eval(xmlhttp.responseText);
        var browserName = navigator.appName;
        var sSelect = targetOBJ;
        //console.log(targetOBJ);
        sSelect.innerHTML = "";
        var oOption1 = document.createElement("option");
        var browser_type = "m";
        oOption1.text = "-Please Select-";
        oOption1.value = "-1";

        if (browserName === "Microsoft Internet Explorer")
        {
            browser_type = "e";
            sSelect.add(oOption1);
        } else
        {
            sSelect.add(oOption1, null);
        }
        if (xmlhttp.responseText === "No Data") {
            var oOption = document.createElement("option");
            oOption.text = targetOBJ.options[targetOBJ.selectedIndex].text;
            oOption.value = targetOBJ.value;
            if (browser_type === "e")
            {
                sSelect.add(oOption);
            } else
            {
                sSelect.add(oOption, null);
            }
        } else { /*wlistArray and wlistIDArray are declared inside the AjaxServlet*/

            for (i = 0; i < wlistArray.length; i++)
            {
                var oOption = document.createElement("option");
                oOption.text = wlistArray[i];
                oOption.value = wlistIDArray[i];

                if (browser_type === "e")
                {
                    sSelect.add(oOption);
                } else
                {
                    sSelect.add(oOption, null);
                }
            }
        }
    }
}

function dependentDropDown1(sourceDD, sourceDD1, targetDD, category) {
    var i;

//    var sources = sourceDD.split("~");
//    if (sources.length === 1) {
//        url += sources.length + "&keyword=" + sources[0].value;
//    } else if (sources.length > 1) {
//        url += sources.length;
//        for (j = 0; j < sources.length; j++) {
//            url += "&keyword_" + (j + 1) + "=" + sources[j].value;
//        }
//    }

    var sourceOBJ = document.getElementById(sourceDD);
    var sourceOBJ1 = document.getElementById(sourceDD1);
    var targetOBJ = document.getElementById(targetDD);
    var url = "../sas/AjaxServlet?category=" + category + "&value=" + sourceOBJ.value + "&value1=" + sourceOBJ1.value;
    if (xmlhttp) {
        xmlhttp.open("POST", url, false);
        xmlhttp.send("");
        eval(xmlhttp.responseText);
        var browserName = navigator.appName;
        var sSelect = targetOBJ;
        sSelect.innerHTML = "";
        var oOption1 = document.createElement("option");
        var browser_type = "m";
        oOption1.text = "-Please Select-";
        oOption1.value = "-1";

        if (browserName === "Microsoft Internet Explorer")
        {
            browser_type = "e";
            sSelect.add(oOption1);
        } else
        {
            sSelect.add(oOption1, null);
        }
        if (xmlhttp.responseText === "No Data") {
            var oOption = document.createElement("option");
            oOption.text = targetOBJ.options[targetOBJ.selectedIndex].text;
            oOption.value = targetOBJ.value;
            if (browser_type === "e")
            {
                sSelect.add(oOption);
            } else
            {
                sSelect.add(oOption, null);
            }
        } else { /*wlistArray and wlistIDArray are declared inside the AjaxServlet*/
            for (i = 0; i < wlistArray.length; i++)
            {
                var oOption = document.createElement("option");
                oOption.text = wlistArray[i];
                oOption.value = wlistIDArray[i];

                if (browser_type === "e")
                {
                    sSelect.add(oOption);
                } else
                {
                    sSelect.add(oOption, null);
                }
            }
        }
    }
}


function dependentDropDownBatch(sourceDD, sourceDD1, sourceDD2, targetDD, category) {
    var i;

    var sourceOBJ = document.getElementById(sourceDD);
    var sourceOBJ1 = document.getElementById(sourceDD1);
    var sourceOBJ2 = document.getElementById(sourceDD2);
    var targetOBJ = document.getElementById(targetDD);
    var url = "../sas/AjaxServlet?schmb=" + category + "&schemeId=" + sourceOBJ.value + "&finYr=" + sourceOBJ1.value + "&instl=" + sourceOBJ2.value;
    if (xmlhttp) {
        xmlhttp.open("POST", url, false);
        xmlhttp.send("");
        eval(xmlhttp.responseText);
        var browserName = navigator.appName;
        var sSelect = targetOBJ;
        sSelect.innerHTML = "";
        var oOption1 = document.createElement("option");
        var browser_type = "m";
        oOption1.text = "-Please Select-";
        oOption1.value = "-1";

        if (browserName === "Microsoft Internet Explorer")
        {
            browser_type = "e";
            sSelect.add(oOption1);
        } else
        {
            sSelect.add(oOption1, null);
        }
        if (xmlhttp.responseText === "No Data") {
            var oOption = document.createElement("option");
            oOption.text = targetOBJ.options[targetOBJ.selectedIndex].text;
            oOption.value = targetOBJ.value;
            if (browser_type === "e")
            {
                sSelect.add(oOption);
            } else
            {
                sSelect.add(oOption, null);
            }
        } else { /*wlistArray and wlistIDArray are declared inside the AjaxServlet*/
            for (i = 0; i < wlistArray.length; i++)
            {
                var oOption = document.createElement("option");
                oOption.text = wlistArray[i];
                oOption.value = wlistIDArray[i];

                if (browser_type === "e")
                {
                    sSelect.add(oOption);
                } else
                {
                    sSelect.add(oOption, null);
                }
            }
        }
    }
}


function addLandtoBeneficiary(sl_no, plot_no, plot_area, plot_area_unit, plot_land_class, plot_land_subclass, owners_info_from_lr) {
    $("#landMappedDiv").removeClass("d-none");
    var beneficiary_id = $('#hdnBenId').val();
    var state_code = 16;
    var dist_code = $('#ddlDistrict2  option:selected').val();
    var dist_name = $('#ddlDistrict2  option:selected').text();
    var subdiv_code = $('#ddlSubDiv2  option:selected').val();
    var subdiv_name = $('#ddlSubDiv2  option:selected').text();
    var rev_circle_code = $('#ddlRevCircle  option:selected').val();
    var rev_circle_name = $('#ddlRevCircle  option:selected').text();
    var tehsil_code = $('#ddlTehsil  option:selected').val();
    var tehsil_name = $('#ddlTehsil  option:selected').text();
    var rev_vill_code = $('#ddlRevVill  option:selected').val();
    var rev_vill_name = $('#ddlRevVill  option:selected').text();
    var khatian_no = $('#txtKhatianNo').val();
    var ownership_type = $('input[name="radOwnershipType_' + sl_no + '"]:checked').val();
    //var ownership_type = $("input[name='radOwnershipType_" + sl_no + "']:checked").val();
    alert(ownership_type);
    var ownership_share = $('#txtOwnersPlotShare_' + sl_no).val();

    var url = "../LRDataCheck?beneficiary_id=" + beneficiary_id + "&state_code=" + state_code + "&dist_code=" + dist_code + "&subdiv_code=" + subdiv_code + "&rev_circle_code=" + rev_circle_code + "&tehsil_code=" + tehsil_code;
    url += "&rev_vill_code=" + rev_vill_code + "&dist_name=" + dist_name + "&subdiv_name=" + subdiv_name + "&rev_circle_name=" + rev_circle_name + "&tehsil_name=" + tehsil_name;
    url += "&rev_vill_name=" + rev_vill_name + "&khatian_no=" + khatian_no + "&plot_no=" + plot_no + "&plot_area=" + plot_area + "&plot_area_unit=" + plot_area_unit + "&plot_land_class=" + plot_land_class;
    url += "&plot_land_subclass=" + plot_land_subclass + "&ownership_type=" + ownership_type + "&ownership_share=" + ownership_share + "&owners_info_from_lr=" + owners_info_from_lr + "&mapPlot=1";

    if (xmlhttp) {
        xmlhttp.open("POST", url, false);
        xmlhttp.send("");
        eval(xmlhttp.responseText);
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            /* if (msg === "no") {
             return false;
             } else {
             return true;
             }*/
            alert(xmlhttp.responseText);
        }
    }
}
function setPin() {
    var selPo = document.getElementById("ddlPo");

    if (selPo.value === "" || selPo.value === "-1" || selPo.value === "0") {
        document.getElementById("txtAddrPIN").value = "";
    } else {
        var pin = selPo.value.split('#')[1];
        document.getElementById("txtAddrPIN").value = pin;
    }
}
function resetBlock(seq) {
    if (seq === 1) {
        //setSelected("ddlLocType", "");
        //showHideBlock();  
        $('#ddlSubDiv1').empty().append('<option value="0">-Please Select-</option>');
        $('#ddlUrbRurBody').empty().append('<option value="0">-Please Select-</option>');
        $('#ddlWardGp').empty().append('<option value="0">-Please Select-</option>');
    } else if (seq === 2) {
        //setSelected("ddlLocType", "");
        //showHideBlock();
        $('#ddlUrbRurBody').empty().append('<option value="0">-Please Select-</option>');
        $('#ddlWardGp').empty().append('<option value="0">-Please Select-</option>');
    } else if (seq === 3) {
        $('#ddlWardGp').empty().append('<option value="0">-Please Select-</option>');
    } else if (seq === 4) {
        //setSelected("ddlLocType", "");
        //showHideBlock();  
        $('#ddlSubDiv').empty().append('<option value="0">-Please Select-</option>');
        $('#ddlUrbRurBody').empty().append('<option value="0">-Please Select-</option>');
        $('#ddlVlwStore').empty().append('<option value="0">-Please Select-</option>');
    } else if (seq === 5) {
        //setSelected("ddlLocType", "");
        //showHideBlock();
        $('#ddlUrbRurBody').empty().append('<option value="0">-Please Select-</option>');
        $('#ddlVlwStore').empty().append('<option value="0">-Please Select-</option>');
    } else if (seq === 6) {
        $('#ddlVlwStore').empty().append('<option value="0">-Please Select-</option>');
    } else if (seq === 7) {
        //setSelected("ddlLocType", "");
        //showHideBlock();  
        $('#ddlSubDiv').empty().append('<option value="0">-Please Select-</option>');
        $('#ddlUrbRurBody').empty().append('<option value="0">-Please Select-</option>');
        //$('#ddlVlwStore').empty().append('<option value="0">-Please Select-</option>');
    } else if (seq === 8) {
        //setSelected("ddlLocType", "");
        //showHideBlock();  
        $('#ddlSubDiv1').empty().append('<option value="0">-Please Select-</option>');
        $('#ddlWardGp').empty().append('<option value="0">-Please Select-</option>');
        //$('#ddlVlwStore').empty().append('<option value="0">-Please Select-</option>');
    }


}



