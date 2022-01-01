<%-- 
    Document   : formsas
    Created on : 05-Nov-2021, 14:28:59
    Author     : Diptanu
--%>
<%@page import="common.CommonMethod"%>
<%
    String ddlDist = "";
    String ddlLoc = "";
    String eduQly = "";
    String occupation = "";
    common.CommonMethod cm = new CommonMethod();
    ddlDist = cm.getDistrict("-Please Select-");
    // ddlLoc = cm.getLocation("-Please Select-");
    //  eduQly = cm.getEducationQly("-Please Select-");
    //  occupation = cm.getOccupation("-Please Select-");
    String regMsg = "";
    String type = "light";
%>   
<!DOCTYPE html>
<html lang="en">

    <head> 
        <title>SAS </title>
        <jsp:include page="import/headerlogin.jsp"></jsp:include>  
            <link href="assets/css/lib/toastr/toastr.min.css" rel="stylesheet">
            <link href="assets/css/lib/select2/select2.min.css" rel="stylesheet">
            <style>
                .media{
                    height: 50px;
                }
                .table tbody tr.highlight td {
                    background-color: #cce0ff; font-weight: bold;
                }
                .dataTables_wrapper{
                    padding-left: 5px;
                    padding-right: 5px;
                }
                .modal-backdrop
                {
                    opacity:0.5 !important;
                }
                .font-text
                {
                    font-size: .9rem;
                }
                .field-container {
                    display: inline-block;
                    font-size: 0.6rem;
                }
                 .greenStyle{
/*                    display: table;*/
                    padding:5px;
                    background-color:#adebad;
                    color:#000000;
                }
                 .redStyle{
/*                    display: table;*/
                    padding:5px;
                    background-color:#ff9966;
                    color:#00000;
                }

            </style>
        </head>

        <body>
        <jsp:include page="import/sidebarmenu.jsp"></jsp:include>  

            <div class="content-wrap">
                <div class="main">
                    <div class="container-fluid">
                        <div style="min-height: 75vh; display: flex; flex-direction: column;">
                            <div class="row" style="height: 40px;">
                                <div class="col-lg-8 col-sm-6 p-r-02 title-margin-right" style="padding-top: 0px; padding-bottom: 0px;">
                                    <div class="page-header">
                                        <div class="page-title">
                                            <h1> <span> </span></h1>
                                        </div>
                                    </div>
                                </div>
                                <!-- /# column -->
                                <div class="col-lg-4 col-sm-6 p-l-02 title-margin-left" style="padding-top: 0px; padding-bottom: 0px;">
                                    <div class="page-header" style="margin:  0 0 0 0;">
                                        <div class="page-title" style="margin:  0 0 0 0;">
                                            <ol class="breadcrumb">
                                                <li class="breadcrumb-item"><a href="#">Menu</a></li>
                                                <li class="breadcrumb-item active">SAS Form</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div>
                                <!-- /# column -->
                            </div>
                            <!-- /# row -->
                            <section id="main-content">

                                <div class="row" >
                                    <div class="col-lg-12" style="padding-top: 0px; padding-bottom: 0px;">
                                        <div class="card" style="padding-top: 5px; padding-bottom: 0px;margin-top: 5px; margin-bottom: 5px">
                                            <div class="card-title">
                                                <h4 class="font-text"> Search RC</h4>  

                                            </div>
                                            <div class="row card-body" style="padding-top: 0px; padding-bottom: 0px;">
                                                <div class="float-left col-lg-6 col-md-8 col-sm-12" style="padding-top: 0px; padding-bottom: 0px;">
                                                    <form method="post">
                                                        <div class="form-group">
                                                            <!--                                                            <label></label>-->
                                                            <div class="input-group input-group-rounded has-default">
                                                                <input type="text" placeholder="Enter RC No." name="txtRationCardNo" id="txtRationCardNo" class="form-control font-text">
                                                                <span class="input-group-btn"><button class="btn btn-primary btn-group-right" id="btnSearchRcnumber" type="button"><i class="ti-search"></i></button></span>
                                                            </div>                                                             
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="float-right col-lg-6 col-md-4 col-sm-12" style="padding-top: 0px; padding-bottom: 0px;">
                                                    <div id="" class="float-right" style="height: 1.8rem;">
                                                        <div  class="form-check-inline">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="methodType" checked="">eKyc
                                                            </label>
                                                        </div>
                                                        <div class="form-check-inline">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="methodType" disabled="">Insertion
                                                            </label>
                                                        </div>
                                                        <div class="form-check-inline">
                                                            <label class="form-check-label">
                                                                <input type="radio" class="form-check-input" name="methodType" disabled="">Deletion
                                                            </label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /# column -->

                                </div>
                                <!-- /# row -->

                                <div class="row  d-none" id="memberListDiv" style="padding-top: 0px; padding-bottom: 0px;">
                                    <div class="col-lg-12" style="padding-top: 0px; padding-bottom: 0px;">
                                        <div class="card" style="padding-top: 5px; padding-bottom: 5px; padding-left: 10px;padding-right: 10px; margin-top: 0px;margin-bottom: 5px;">
                                            <div class="card-title">
                                                <!--                                                <h4>RC Details </h4>
                                                                                                <span class="text-primary m-b-15 f-s-12" id="rcinfo"></span>-->
                                            </div>
                                            <div class="card-body" style="margin: 0px 0px 0px 0px;">
                                                <div class="table-responsive" style="margin: 0px 0px 0px 0px;">
                                                    <table  id="memberList"class="table table-bordered w-100" style="margin:  0px 0px 0px 0px;">
                                                        <thead>
                                                            <tr>
                                       
                                                                <th>Member Id</th>
                                                                <th>Member Name</th>
                                                                <th>Sex</th>
                                                                <th>DOB</th>
                                                                <th>Mobile</th>
                                                                <th>Masked Aadhaar</th>
                                                                <th>HOF(Y/N)</th>
                                                                <th>Select</th>
                                                            </tr>
                                                        </thead>  

                                                        <tbody>
                                                            <!--                                                    <tr>
                                                                                                                    <td scope="row">1</td>
                                                                                                                    <td>5686</td>
                                                                                                                    <td>Pradip</td>
                                                                                                                    <td>M</td>
                                                                                                                    <td>10/05/1999</td>
                                                                                                                    <td>888888888</td>
                                                                                                                    <td>xxxxxxxx2569</td>
                                                                                                                    <td>Y</td>
                                                                                                                    <td> <button type="button" class="btn btn-primary btn-flat btn-addon m-b-10 m-l-5" data-toggle="modal" data-target="#aadhaarModal"><i class="ti-plus"></i>Select</button></td>
                                                                                                                </tr>   -->
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card" style="padding-top: 5px; padding-bottom: 0px;margin-top: 5px; margin-bottom: 5px">
                                            <div class="card-title">
                                                <h4 class="font-text"> RC Address</h4> 
                                            </div>
                                            <div id="collapseBenAddr" class="collapse show" data-parent="#accordion">
                                                <div class="card-body bg-form">
                                                    <div class="form-group">                                    
                                                        <div class="row">                                        
                                                            <div class="form-group  col-sm-4 col-md-3 col-lg-3 ">
                                                                <label for="ddlDistrict1">District</label><span style="color:red;"></span>
                                                                <small class="text-muted" id="dbDistrict"></small>
                                                                <div class="input-group mb-3">
                                                                    <div class="input-group-prepend">
                                                                        <span class="input-group-text" id="basic-addon1"><i class="fa fa-address-card-o"></i></span>
                                                                    </div>                                                               
                                                                    <select id="ddlDistrict1" name="ddlDistrict1" class="form-control form-control-sm" onchange="resetBlock(1);
                                                                            dependentDropDown('ddlDistrict1', 'ddlSubDiv1', 'fillSubDiv');
                                                                            dependentDropDown('ddlDistrict1', 'ddlPs', 'fillPoliceStation');" >
                                                                    <%= ddlDist%>     


                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group col-sm-4 col-md-3 col-lg-3 ">
                                                            <label for="ddlSubDiv1">Sub-Division</label><span style="color:red;"></span>
                                                            <small class="text-muted" id="dbSubdivision"></small>
                                                            <div class="input-group mb-3">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-address-book-o"></i></span>
                                                                </div>
                                                                <select id="ddlSubDiv1" name="ddlSubDiv1" class="form-control form-control-sm" onchange="resetBlock(2);
                                                                        dependentDropDown('ddlSubDiv1', 'ddlUrbRurBody', 'fillBlock');
                                                                        dependentDropDown('ddlSubDiv1', 'ddlPo', 'fillPostOffice');
                                                                        "  >
                                                                    <option value="0">-Please Select-</option>                                                 
                                                                </select>
                                                            </div>
                                                        </div>


                                                        <div class="form-group col-sm-4 col-md-3 col-lg-3 ">
                                                            <label for="ddlUrbRurBody">MC/Block/ADC Block</label> <span style="color:red;"></span> 
                                                            <small class="text-muted" id="dbBlock"></small>
                                                            <div class="input-group mb-3">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-map-marker"></i></span>
                                                                </div>
                                                                <select id="ddlUrbRurBody" name="ddlUrbRurBody" class="form-control form-control-sm" onchange="dependentDropDown('ddlUrbRurBody', 'ddlWardGp', 'fillGp');" >
                                                                    <option value="0">-Please Select-</option>                                                 
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group  col-sm-4 col-md-3 col-lg-3 ">
                                                            <label for="ddlWardGp">Ward/GP/VC</label><span style="color:red;"></span>
                                                            <small class="text-muted" id="dbGp"></small>
                                                            <div class="input-group mb-3">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-location-arrow"></i></span>
                                                                </div>
                                                                <select id="ddlWardGp" name="ddlWardGp" class="form-control form-control-sm" >
                                                                    <option value="0">-Please Select-</option>                                                 
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div> 
                                                    <div class="row">                                                
                                                        <div class="form-group  col-sm-4 col-md-3 col-lg-3 ">
                                                            <label for="txtAddrOth">Habitation / Para</label><span style="color:red;"></span>
                                                            <div class="input-group mb-3">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-sort-alpha-desc"></i></span>
                                                                </div>
                                                                <input type="text" id="txtAddrOth" name="txtAddrOth" class="form-control form-control-sm"  />
                                                            </div>
                                                        </div>
                                                        <div class="form-group col-sm-4 col-md-3 col-lg-3">
                                                            <label for="ddlPs">Police Station</label>
                                                            <div class="input-group mb-3">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-id-card-o"></i></span>
                                                                </div>
                                                                <select id="ddlPs" name="ddlPs" class="form-control form-control-sm">
                                                                    <option value="0">-Please Select-</option>                                                 
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group col-sm-4 col-md-3 col-lg-3">
                                                            <label for="ddlPo">Post Office</label>
                                                            <div class="input-group mb-3">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-id-card-o"></i></span>
                                                                </div>
                                                                <select id="ddlPo" name="ddlPo" class="form-control form-control-sm" onchange="setPin();">
                                                                    <option value="0">-Please Select-</option>                                                 
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group  col-sm-4 col-md-3 col-lg-3">
                                                            <label for="txtAddrPIN">PIN</label>
                                                            <div class="input-group mb-3">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text" id="basic-addon1"><i class="fa fa-sort-numeric-asc"></i></span>
                                                                </div>
                                                                <input type="text" id="txtAddrPIN" name="txtAddrPIN" class="form-control form-control-sm"  />
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>                                
                                            </div>   
                                        </div>
                                    </div> 
                                </div>
                                <!-- /# column -->
                            </div>
                            <!-- row compare -->
                            <div class="row " id="" style="padding-top: 0px; padding-bottom: 0px;">
                                <div class="col-lg-12" style="padding-top: 0px; padding-bottom: 0px;">

                                    <div class="card  collapse" id="comparediv" style="padding-top: 5px; padding-bottom: 5px; padding-left: 10px;padding-right: 10px; margin-top: 0px;margin-bottom: 5px;">
                                        <div class="card-title pr">
                                            <h4>Compare RC vs Aadhaar</h4>
                                            <div class="checkbox font-text">
                                                <label><input type="checkbox" id="chkCompareMatch"> 
                                                    Hide Matching Fields
                                                </label>
                                            </div>
                                        </div> 
                                        <div class="" style="min-width: 900px; scrollbar-width: none;">
                                            <div class="card-body">
                                                <div class="row">                              
                                                    <div class="col-lg-2 col-sm-2 col-2" style="padding-left: 2px; padding-right: 1px">
                                                        <div class="card"   style="padding: 10px 10px 10px 10px">
                                                            <div class="card-title"  style="height: 60px;">
                                                                <div class="stat-icon dib">
                                                                    <i class="ti-layout-grid2 color-success border-pink"></i>
                                                                </div>
                                                                <h4 class="color-primary">Fields</h4></hr>
                                                            </div>
                                                            <div class="card-body">
                                                                <div class="recent-comment m-t-2">
                                                                    <div class="media cmpMemberName">                                                        
                                                                        <div class="media-body2">
                                                                            <span class="media-heading color-info font-text">Full Name</span>
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMemberNameLocal">                                                        
                                                                        <div class="media-body2">
                                                                            <span class="media-heading color-info font-text">Full Name (Bengali)</span>
                                                                        </div>
                                                                    </div>

                                                                    <div class="media cmpSex">                                                        
                                                                        <div class="media-body2">
                                                                            <span class="media-heading color-info font-text">Sex</span>
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpDob">                                                        
                                                                        <div class="media-body2">
                                                                            <span class="media-heading color-info font-text">DOB</span>
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpFathername">                                                        
                                                                        <div class="media-body2">
                                                                            <span class="media-heading color-info font-text">Father Name</span>
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMothername">                                                        
                                                                        <div class="media-body2">
                                                                            <span class="media-heading color-info font-text">Mother  Name</h4>
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMobile">                                                        
                                                                        <div class="media-body2">
                                                                            <span class="media-heading color-info font-text">Mobile</span>
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpEmail">                                                        
                                                                        <div class="media-body2">
                                                                            <span class="media-heading color-info font-text">Email</span>
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpAadhaar">                                                        
                                                                        <div class="media-body2">
                                                                            <span class="media-heading color-info font-text">Aadhaar</h4>
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpAddress">                                                        
                                                                        <div class="media-body2">
                                                                            <span class="media-heading color-info font-text">Address</span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- /# card -->
                                                    </div>
                                                    <!-- /# column -->
                                                    <div class="col-lg-4 col-sm-4 col-4" style="padding-left: 1px; padding-right: 1px">
                                                        <div class="card"  style="padding: 10px 10px 10px 10px">
                                                            <div class="card-title" style="height: 60px;">
                                                                <div class="float-left">
                                                                    <div class="stat-icon dib">
                                                                        <i class="fa fa-address-book-o color-success border-pink"></i>
                                                                    </div>
                                                                    <h4 class="color-primary">RC Data </h4>
                                                                    <p id="rcnoHead" style="font-size: 0.7rem;"></p>
                                                                </div>
                                                                <div class="float-right">
                                                                    <span class="text-primary m-b-15 f-s-12">Mark for Revision</span>
                                                                </div>
                                                            </div>
                                                            <div class="recent-comment m-t-2">
                                                                <div class="media cmpMemberName">                                                        
                                                                    <div class="media-body">                                                               
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcMemberName"></h4> 
                                                                        <p class="comment-date"><input type="checkbox" class="cmpCheck" id="chkrcMemberName"></span></p>                                                            
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpMemberNameLocal">                                                        
                                                                    <div class="media-body">                                                               
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcMemberNameLocal"></h4> 
                                                                        <p class="comment-date"><input type="checkbox" class="cmpCheck" id="chkrcMemberNameLocal"></span></p>                                                            
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>

                                                                <div class="media cmpSex">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcSex"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkrcSex"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpDob">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcDOB"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkrcDOB"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpFathername">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcFatherName"></h4>
                                                                        <p class="comment-date"><input type="checkbox"   class="cmpCheck" id="chkrcFatherName"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpMothername">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcMotherName"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkrcMotherName"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpMobile">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcMobile"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkrcMobile"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpEmail">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcEmail"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkrcEmail"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpAadhaar">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcAadhar"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkrcAadhar"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpAadhaar">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcAddress"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkrcAddress"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- /# card -->
                                                    </div>
                                                    <!-- /# column -->
                                                    <div class="col-lg-4 col-sm-4 col-4" style="padding-left: 1px; padding-right: 1px">
                                                        <div class="card"  style="padding: 10px 10px 10px 10px">
                                                            <div class="card-title" style="height: 60px;">
                                                                <div class="float-left">
                                                                    <div class="stat-icon dib">
                                                                        <i class="fa fa-id-card color-success border-pink"></i>
                                                                    </div>
                                                                    <h4 class="color-primary">Aadhaar Data </h4>
                                                                    <p id="aadhaarnoHead" style="font-size: 0.7rem;"></p>
                                                                </div>
                                                                <div class="float-right">
                                                                    <span class="text-primary m-b-15 f-s-12">Mark for Revision</span>
                                                                </div>
                                                            </div>
                                                            <div class="recent-comment m-t-2">
                                                                <div class="media cmpMemberName" style="padding-top: 1px;">
                                                                    <div class="media-left" >                                                           
                                                                        <img class="media-object" height="40px" width="40px" src="assets/images/user.jpg"   alt="img" >
                                                                    </div>
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarMemberName"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkaadhaarMemberName"></span></p> 
                                                                        <p></p>                                                            
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpMemberNameLocal">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarMemberNameLocal"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkaadhaarMemberNameLocal"></span></p>                                                                                                                       
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>

                                                                <div class="media cmpSex">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarSex"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkaadhaarSex"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpDob">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarDOB"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkaadhaarDOB"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpFathername">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarFatherName"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkaadhaarFatherName"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpMothername">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarMotherName"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkaadhaarMotherName"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpMobile">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarMobile"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkaadhaarMobile"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpEmail">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarEmail"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkaadhaarEmail"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpAadhaar">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarAadhar"></h4>
                                                                        <!--                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkaadhaarAadhar"></span></p>     -->
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpAddress">
                                                                    <div class="media-body">
                                                                        <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarAddress"></h4>
                                                                        <p class="comment-date"><input type="checkbox"  class="cmpCheck" id="chkaadhaarAddress"></span></p>     
                                                                        <p></p>                                                           
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- /# card -->
                                                    </div>
                                                    <!-- /# column -->
                                                    <div class="col-lg-2 col-sm-2 col-2" style="padding-left: 1px; padding-right: 1px">
                                                        <div class="card"  style="padding: 10px 10px 10px 10px">
                                                            <div class="card-title" style="height: 60px;">                                                      
                                                                <div class="stat-icon dib">
                                                                    <i class="fa fa-bookmark-o color-success border-pink"></i>
                                                                </div>
                                                                <h4 class="color-primary">New Entry  </h4>
                                                            </div>
                                                            <div class="recent-comment m-t-2">

                                                                <div class="media cmpMemberName">                                                    
                                                                    <div class="form-group input-group-rounded has-default">
                                                                        <div class="input-group ">
                                                                            <input type="text" placeholder="Correct Member Name" name="updMemberName" id="updMemberName" class="form-control font-text"  style="height: 1.8rem; display: none">
                                                                        </div>   
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpMemberNameLocal">                                                    
                                                                    <div class="form-group input-group-rounded has-default">
                                                                        <div class="input-group ">
                                                                            <input type="text" placeholder="" name="updMemberNameLocal" id="updMemberNameLocal" class="form-control font-text"  style="height: 1.8rem; display: none">
                                                                        </div>   
                                                                    </div>
                                                                </div>                                                               
                                                                <div class="media cmpSex">
                                                                    <div class="form-group input-group-rounded has-default">
                                                                        <div class="input-group ">
                                                                            <div id="updSex" style="height: 1.8rem; display: none">
                                                                                <div  class="form-check-inline">
                                                                                    <label class="form-check-label">
                                                                                        <input type="radio" class="form-check-input" name="updSex">Male
                                                                                    </label>
                                                                                </div>
                                                                                <div class="form-check-inline">
                                                                                    <label class="form-check-label">
                                                                                        <input type="radio" class="form-check-input" name="updSex">Female
                                                                                    </label>
                                                                                </div>
                                                                            </div>
                                                                            <!--                                                                            <input type="text" placeholder="" name="updSex" id="updSex" class="form-control" style="height: 1.8rem; display: none">-->
                                                                        </div>   
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpDob">
                                                                    <div class="form-group input-group-rounded has-default">
                                                                        <div class="input-group ">
                                                                            <div id="updDOB" style="height: 1.8rem; display: none;">
                                                                                <div class="field-container">
                                                                                    <select name="dobYear" class="dobYear">
                                                                                    </select>
                                                                                </div>
                                                                                <div class="field-container month">
                                                                                    <select name="dobMonth" class="dobMonth">
                                                                                        <option value="">MM</option>
                                                                                        <option value="1">Jan</option>
                                                                                        <option value="2">Feb</option>
                                                                                        <option value="3">Mar</option>
                                                                                        <option value="4">Apr</option>
                                                                                        <option value="5">May</option>
                                                                                        <option value="6">Jun</option>
                                                                                        <option value="7">Jul</option>
                                                                                        <option value="8">Aug</option>
                                                                                        <option value="9">Sep</option>
                                                                                        <option value="10">Oct</option>
                                                                                        <option value="11">Nov</option>
                                                                                        <option value="12">Dec</option>
                                                                                    </select>
                                                                                </div>
                                                                                <div class="field-container">
                                                                                    <select name="dobDay" class="dobDay">
                                                                                        <option value="">DD</option>
                                                                                    </select>
                                                                                </div>

                                                                            </div>

                                                                            <!--                                                                            <input class="datepicker form-control" name="updDob" id="updDOB" data-date-format="mm/dd/yyyy" style="height: 1.8rem; display: none">-->
                                                                            <!--                                                                            <input type="text" placeholder="" name="updDob" id="updDOB" class="form-control"  style="height: 1.8rem; display: none">-->
                                                                        </div>   
                                                                    </div>
                                                                </div>

                                                                <div class="media cmpFathername">
                                                                    <div class="form-group input-group-rounded has-default">
                                                                        <div class="input-group ">
                                                                            <input type="text" placeholder="Correct Father Name" name="updFatherName" id="updFatherName" class="form-control font-text"  style="height: 1.8rem; display: none">
                                                                        </div>   
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpMothername">
                                                                    <div class="form-group input-group-rounded has-default">
                                                                        <div class="input-group ">
                                                                            <input type="text" placeholder="Correct Mother Name" name="updMotherName" id="updMotherName" class="form-control font-text"  style="height: 1.8rem; display: none">
                                                                        </div>   
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpMobile">
                                                                    <div class="form-group input-group-rounded has-default">
                                                                        <div class="input-group ">
                                                                            <input type="text" placeholder="" name="updMobile" id="updMobile" maxlength="10" class="form-control font-text"  style="height: 1.8rem; display: none">
                                                                        </div>   
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpEmail">
                                                                    <div class="form-group input-group-rounded has-default">
                                                                        <div class="input-group ">
                                                                            <input type="email" placeholder="" name="updEmail" id="updEmail" maxlength="30" class="form-control font-text"  style="height: 1.8rem; display: none">
                                                                        </div>   
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpAadhaar">
                                                                    <div class="form-group input-group-rounded has-default">
                                                                        <div class="input-group ">
                                                                            <!--                                                                    <input type="text" placeholder="" name="updAadhar" id="updAadhar" class="form-control"  style="height: 1.8rem; display: none">-->
                                                                        </div>   
                                                                    </div>
                                                                </div>
                                                                <div class="media cmpAddress">
                                                                    <div class="form-group input-group-rounded has-default">
                                                                        <div class="input-group ">
                                                                            <input type="text" placeholder="Correct Address" name="updAddress" id="updAddress" class="form-control font-text"  style="height: 1.8rem; display: none">
                                                                        </div>   
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- /# card -->
                                                    </div>
                                                    <!-- /# column -->
                                                </div>
                                                <!-- /# row -->
                                            </div>
                                        </div>
                                        <div class="card-footer pr d-flex justify-content-center">                                  
                                            <button type="button" id="btnSave" class="btn btn-success btn-flat btn-addon m-b-10 m-l-5">
                                                <i class="ti-check-box"></i>Save</button>
                                        </div> 
                                    </div>
                                </div>
                                <!-- /# column -->
                            </div>
                            <!-- /# row compare -->

                            <!-- modal  to enter aadhaar no -->
                            <div class="modal " id="aadhaarModal" style="" >
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">e-KYC<span class="text-primary pl-2 m-b-15 f-s-12" id="ekycrc"> </span></h5>
                                            <button aria-hidden="true" data-dismiss="modal" class="close" type="button"><i class="ti-close"></i></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="progress ">
                                                <div class="progress-bar progress-bar-striped active" role="progressbar"
                                                     aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:100%;">
                                                    EKYC on progress
                                                </div>
                                            </div>
                                            <!--                                            <form method="post">
                                                                                            <div class="form-group">
                                                                                                <label>Aadhaar Number</label>
                                                                                                <div class="input-group input-group-rounded">
                                                                                                    <input type="text" placeholder="Enter Aadhaar No." name="txtAadhaarno" id="txtAadhaarno" class="form-control">
                                                                                                    <span class="input-group-btn"><button class="btn btn-primary btn-group-right" type="button" id="btnEkycAadhaarno"><i class="ti-search"></i></button></span>
                                                                                                </div>   
                                                                                            </div>
                                                                                        </form>-->
                                        </div>
                                        <div class="modal-footer">
                                            <!--   <button type="button" class="btn btn-primary">Save changes</button>-->
                                            <button type="button" id="modalClosebtn" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>   
                            <!-- /# modal -->

                    </div>
                    <!-- / loader -->
                    <div id="loader" style="display:none;width:200px;height:150px;border:1px solid black;position:fixed;text-align: center; border-radius: 25px; top: 40%; right: 0; left: 43%; z-index: 9999999; filter: alpha(opacity=70); opacity: 0.9; ">
                        <img src='assets/images/loader2.gif' width="160" height="120" /><br><span class="text-primary m-b-15 f-s-15 text-center">Loading Please Wait..</span></div>
                    <!-- /# loader -->

                    <jsp:include page="import/footernote.jsp"></jsp:include>  

                        </section>
                    </div>
                </div>
            </div>

        <jsp:include page="import/footer.jsp"></jsp:include>  
            <!-- in page script -->
            <script src="assets/js/lib/toastr/toastr.min.js"></script>
            <script src="assets/js/lib/select2/select2.full.min.js"></script>
            <script src="assets/js/ajaxFunctions.js"></script>

        </body>

        <script>
                                                                    //dob
                                                                    $(".dobYear").select2({
                                                                    });
                                                                    $(".dobDay").select2({
                                                                    });
                                                                    $(".dobMonth").select2({
                                                                    });
                                                                    var month = 1;
                                                                    var year = new Date().getFullYear();
                                                                    var day, seq, daysInMonth, prevDaysInMonth = -1;
// Initializing the Year drop down from current year to current year - 100
                                                                    var yearOption = '<option value="">YYYY</option>';
                                                                    for (i = year; i >= year - 100; i--) {
                                                                        yearOption = yearOption + '<option value=' + i + '>' + i + '</option>';
                                                                    }
                                                                    $('.dobYear').append(yearOption);
// on change of Month/Year drop downs call the "daysInAMonth" function to calculate the number of days and repopulate days dropdown if needed
                                                                    $('.dobMonth').change(function () {
                                                                        month = $(this).val();
                                                                        daysInAMonth();
                                                                    });
                                                                    $('.dobYear').change(function () {
                                                                        year = $(this).val();
                                                                        daysInAMonth();
                                                                    });

                                                                    function daysInAMonth() {
                                                                        //calculate the number of days in a given month and year
                                                                        daysInMonth = new Date(year, month, 1, -1).getDate();
                                                                        // if the number of days is not the same as previous dropdown (number of            days) value then repopulate Days DropDown
                                                                        if (daysInMonth != prevDaysInMonth) {
                                                                            prevDaysInMonth = daysInMonth;
                                                                            day = '<option value="">Day</option>';
                                                                            $('.dobDay').html('');
                                                                            for (i = 1; i <= daysInMonth; i++) {
                                                                                day = day + '<option value=' + i + '>' + (i < 10 ? "0" + i : i) + '</option>';
                                                                            }
                                                                            $('.dobDay').append(day);

                                                                       }
                                                                    }
                                                                    ;
                                                                    //end dob

                                                                    $(document).ready(function () {
                                                                        listFields = {cmpMemberName: "MemberName", cmpMemberNameLocal: "MemberNameLocal", cmpSex: "Sex", cmpDob: "DOB", cmpFathername: "FatherName", cmpMothername: "MotherName", cmpMobile: "Mobile", cmpEmail: "Email", cmpAadhaar: "Aadhar", cmpAddress: "Address"};

                                                                        $('#chkCompareMatch').change(function () {
                                                                            $.each(listFields, function (k, v) {
                                                                                var rcdata = "#rc" + v;
                                                                                var aadhaardata = "#aadhaar" + v;
                                                                                var matchingDiv = "." + k;
                                                                                //  alert(rcdata);
                                                                                if ($("#chkCompareMatch").prop('checked') === true) {
                                                                                    if ($(rcdata).text().toLowerCase().trim() === $(aadhaardata).text().toLowerCase().trim()) {
                                                                                        $(matchingDiv).fadeOut();
                                                                                    }
                                                                                } else {
                                                                                    $(matchingDiv).fadeIn();
                                                                                }
                                                                            });
                                                                        });

                                                                        $('.cmpCheck').change(function () {
                                                                            $.each(listFields, function (k, v) {
                                                                                var rcdataCheck = "#chkrc" + v;
                                                                                var aadhaardataCheck = "#chkaadhaar" + v;
                                                                                var updateField = "#upd" + v;
                                                                                var rcdata = "#rc" + v;
                                                                                var aadhaardata = "#aadhaar" + v;
                                                                                var textcolorForRevision = 'text-danger';

                                                                                if ($(rcdataCheck).prop('checked') === true && $(aadhaardataCheck).prop('checked') === true) {
                                                                                    //  alert(rcdataCheck+$(rcdataCheck).prop('checked') + " "+ aadhaardataCheck+$(aadhaardataCheck).prop('checked') +" "+  updateField);
                                                                                    $(updateField).fadeIn();
                                                                                    $(rcdata).addClass(textcolorForRevision);
                                                                                    $(aadhaardata).addClass(textcolorForRevision);
                                                                                } else {
                                                                                    $(updateField).fadeOut();
                                                                                    if ($(rcdataCheck).prop('checked') === true)
                                                                                        $(rcdata).addClass(textcolorForRevision);
                                                                                    else
                                                                                        $(rcdata).removeClass(textcolorForRevision);
                                                                                    if ($(aadhaardataCheck).prop('checked') === true)
                                                                                        $(aadhaardata).addClass(textcolorForRevision);
                                                                                    else
                                                                                        $(aadhaardata).removeClass(textcolorForRevision);
                                                                                }       
                                                                            });
                                                                        });
                                                                        $('#btnSearchRcnumber').on('click', function (e) {
                                                                            $('#comparediv').addClass("collapse");
                                                                            var pattern = new RegExp("^16[0-9]{10}$");
                                                                            var rcn = $('#txtRationCardNo').val();
                                                                            if (rcn === "") {
                                                                                //    alert("Kindly provide any RC Number");
                                                                                errormsg("Kindly provide any RC Number");
                                                                                return false;
                                                                            }
                                                                            if (!pattern.test(rcn)) {
                                                                                //  alert("You have entered invalid RC Number");
                                                                                errormsg("You have entered invalid RC Number");
                                                                                return false;
                                                                            }
                                                                            var param = "";
                                                                            if (rcn !== "") {
                                                                                param = rcn;
                                                                            }
                                                                            $('#memberListDiv').removeClass("d-none").addClass("d-block");
                                                                            $('#memberList').DataTable().clear().destroy();
                                                                            var table = $('#memberList').DataTable({
                                                                                "bInfo": false, //Dont display info e.g. "Showing 1 to 4 of 4 entries"
                                                                                "paging": false, //Dont want paging                
                                                                                "bPaginate": false, //Dont want paging   
                                                                                "bFilter": false, //hide Search bar
                                                                                "dom": '<"toolbar">frtip',
                                                                                "ajax": {
                                                                                    "url": "${pageContext.request.contextPath}/sasServlet?rcid=" + param,
                                                                                    "type": "POST",
                                                                                    beforeSend: function () {
//                                $('#loader').show();
                                                                                        $(".card").css("opacity", 0.2);
                                                                                        $(".card").find("input, button, submit, textarea, select").attr("disabled", "disabled");
                                                                                        $("#loader").css({"display": "block"});
                                                                                    },
                                                                                    complete: function (data) {
                                                                                        $('#loader').hide();
                                                                                        $(".card").css("opacity", 1.0);
                                                                                        $(".card").find("input, button, submit, textarea, select").removeAttr("disabled", "disabled");
                                                                                        console.log(data['responseJSON']['aaData'][0]['lgd_district_name']);

                                                                                        /* Set District Value and Populate Subdivision and Police Station*/
                                                                                        $('#ddlDistrict1').val(data['responseJSON']['aaData'][0]['lgd_district_code']);
                                                                                        dependentDropDown('ddlDistrict1', 'ddlSubDiv1', 'fillSubDiv');
                                                                                        dependentDropDown('ddlDistrict1', 'ddlPs', 'fillPoliceStation');

                                                                                        /* Set Subdivision Value and Populate Block and Post Office*/
                                                                                        $('#ddlSubDiv1').val(data['responseJSON']['aaData'][0]['lgd_subdiv_code']);
                                                                                        dependentDropDown('ddlSubDiv1', 'ddlUrbRurBody', 'fillBlock');
                                                                                        dependentDropDown('ddlSubDiv1', 'ddlPo', 'fillPostOffice');

                                                                                        /* Set Block Value and Populate GP*/
                                                                                        $('#ddlUrbRurBody').val(data['responseJSON']['aaData'][0]['lgd_block_code']);
                                                                                        dependentDropDown('ddlUrbRurBody', 'ddlWardGp', 'fillGp');

                                                                                        /* Set GP Value*/
                                                                                        $('#ddlWardGp').val(data['responseJSON']['aaData'][0]['lgd_gp_code']);

                                                                                    }
                                                                                },
                                                                                "columnDefs": [
                                                                                    {
                                                                                        "targets": -1,
                                                                                        "responsivePriority": 1,
                                                                                        "data": null,
                                                                                        "defaultContent": "<button type='button' value='1' class='btn btn-primary btn-flat btn-addon m-b-10 m-l-5 aadhaarKyc' data-toggle='modal' data-target='#aadhaarModal'><i class='ti-arrow-circle-right'></i>&nbsp;</button>"
                                                                                    }
                                                                                ],
                                                                                //   'order': [[3, 'asc']],
                                                                                'responsive': true,
                                                                                "language": {
                                                                                    "emptyTable": "No records to display, please re-check your ration card no."
                                                                                },
                                                                                "aoColumns": [
                                                                                    {"data": "rowno"},
                                                                                    {"data": "ration_card_memberid"},
                                                                                    {"data": "member_name_en"},
                                                                                    {"data": "gender"},
                                                                                    {"data": "member_dob"},
                                                                                    {"data": "mobile"},
                                                                                    {"data": "uid"},
                                                                                    {"data": "hof"},
                                                                                    {"data": null}
                                                                                ]
                                                                            });
                                                                            //scroll down to div position
                                                                            $('html, body').animate({
                                                                                scrollTop: parseInt($("#memberListDiv").offset().top)
                                                                            }, 50);
                                                                            //  $("#rcinfo").html('Members of Ration Card No. ' + rcn);
                                                                            $('#memberList_wrapper').addClass("col-md-12");



                                                                            $('#memberList tbody').on('click', 'button', function (e) {

                                                                                if (parseInt(this.value) === 1) {
                                                                                    var table2 = $('#memberList').DataTable();
                                                                                    var rowRcData = table2.row($(this).parents('tr')).data(); //alert(table2.row($(this).parents('tr')).data());
                                                                                    $(this).parents('tr').addClass('highlight').siblings().removeClass('highlight');
                                                                                    $('#ekycrc').text('rc memberid: ' + rowRcData['ration_card_memberid']);
                                                                                    // alert(encodeURI(rowRcData['lgd_block_code']));
                                                                                    //ekyc aadhaar click
                                                                                    //     $('#btnEkycAadhaarno').on('click', function (e) {
//                                var aid = $('#txtAadhaarno').val();
//                                var regexp = /^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$/;
//                                if (aid === "") {
//                                    errormsg("Kindly provide an Aadhaar Number");
//                                    return false;
//                                }
//                                if (!regexp.test(aid)) {
//                                    errormsg("You have entered invalid Aadhaar Number");
//                                    return false;
//                                }
                                                                                    $.ajax({
                                                                                        "url": "${pageContext.request.contextPath}/sasServlet?ekycrcmember=" + rowRcData['ration_card_memberid'],
                                                                                        cache: false,
                                                                                        processData: false,
                                                                                        // contentType: false,
                                                                                        type: 'POST',
                                                                                        dataType: 'json',
                                                                                        beforeSend: function () {
                                                                                            //   $('#aadhaarModal').modal('show');

                                                                                            $('#loader').show();
                                                                                            $(".card").css("opacity", 0.2);
                                                                                            $(".card").find("input, button, submit, textarea, select").attr("disabled", "disabled");
                                                                                            $("#loader").css({"display": "block"});
                                                                                        },
                                                                                        complete: function () {
//                                    $('#aadhaarModal').modal('hide');
//                                    $(".modal-backdrop").remove();
                                                                                            $('#loader').hide();
                                                                                            $(".card").css("opacity", 1.0);
                                                                                            $(".card").find("input, button, submit, textarea, select").removeAttr("disabled", "disabled");
                                                                                        },
                                                                                        success: function (result) {
                                                                                            var aadhaarData = result["aaData"][0];
                                                                                            //  console.log(aadhaarData['mobile']);
                                                                                            $('#comparediv').removeClass("collapse");
                                                                                            //scroll down to div position
                                                                                            $('html, body').animate({
                                                                                                scrollTop: parseInt($("#comparediv").offset().top)
                                                                                            }, 100);
                                                                                            $('#rcnoHead').text('Memberid: ' + rowRcData['ration_card_memberid']);
                                                                                            $('#aadhaarnoHead').text('Aadhaar: ' + aadhaarData['uid']);
                                                                                            setCmpRCAadhaarValue(rowRcData, aadhaarData);
                                                                                        }
                                                                                    });
                                                                                    //   }); //   end ekyc aadhaar click

                                                                                } // end if value =1
                                                                            });
                                                                        }); //end click rc search button

                                                                    });
                                                                    function  setCmpRCAadhaarValue(rowRcData, aadhaarData) {
                                                                        checkEmptyAndSet('rcMemberName', rowRcData['member_name_en']);
                                                                        checkEmptyAndSet('rcMemberNameLocal', decodeURI(rowRcData['member_name_ll']));
                                                                        // checkEmptyAndSet('rcMemberId', rowRcData['ration_card_memberid']);
                                                                        checkEmptyAndSet('rcSex', rowRcData['gender']);
                                                                        checkEmptyAndSet('rcDOB', rowRcData['member_dob']);
                                                                        checkEmptyAndSet('rcFatherName', rowRcData['father_name']);
                                                                        checkEmptyAndSet('rcMotherName', rowRcData['mother_name']);
                                                                        checkEmptyAndSet('rcMobile', rowRcData['mobile']);
                                                                        checkEmptyAndSet('rcEmail', rowRcData['email']);
                                                                        checkEmptyAndSet('rcAadhar', rowRcData['uid']);
                                                                        checkEmptyAndSet('rcAddress', rowRcData['lgd_address']);
                                                                        checkEmptyAndSet('aadhaarMemberName', aadhaarData['member_name_en']);
                                                                        checkEmptyAndSet('aadhaarMemberNameLocal', decodeURI(aadhaarData['member_name_ll']));
                                                                        //   checkEmptyAndSet('aadhaarMemberId', aadhaarData['ration_card_memberid']);
                                                                        checkEmptyAndSet('aadhaarSex', aadhaarData['gender']);
                                                                        checkEmptyAndSet('aadhaarDOB', aadhaarData['member_dob']);
                                                                        checkEmptyAndSet('aadhaarFatherName', aadhaarData['father_name']);
                                                                        checkEmptyAndSet('aadhaarMotherName', aadhaarData['mother_name']);
                                                                        checkEmptyAndSet('aadhaarMobile', aadhaarData['mobile']);
                                                                        checkEmptyAndSet('aadhaarEmail', aadhaarData['email']);
                                                                        checkEmptyAndSet('aadhaarAadhar', aadhaarData['uid']);
                                                                        checkEmptyAndSet('aadhaarAddress', aadhaarData['lgd_address']);
                                                                    }
                                                                    function  checkEmptyAndSet(fieldid, value) {
                                                                        if (value) {
                                                                            $("#" + fieldid).html(value);
                                                                        } else {
                                                                            $("#" + fieldid).removeClass("color-dark").addClass("color-danger");
                                                                            $("#" + fieldid).html("X");
                                                                        }
                                                                    }
    </script>
    <script>

    </script>

    <script>
        function errormsg(msg) {
            toastr.error(msg, 'Error', {
                "positionClass": "toast-top-center",
                timeOut: 5000,
                "closeButton": true,
                "debug": false,
                "newestOnTop": true,
                "progressBar": true,
                "preventDuplicates": true,
                "onclick": null,
                "showDuration": "300",
                "hideDuration": "1000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut",
                "tapToDismiss": false

            })
        }


    </script>

</html>