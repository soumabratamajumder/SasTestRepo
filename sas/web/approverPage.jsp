<%-- 
    Document   : approverPage
    Created on : Dec 4, 2021, 12:12:22 PM
    Author     : soumabratamajumder
--%>

<%@page import="Security.SecurityClass"%>
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


                                <div class="row  d-none" id="memberListDiv" style="padding-top: 0px; padding-bottom: 0px;">
                                    <div class="col-lg-12" style="padding-top: 0px; padding-bottom: 0px;">
                                        <div class="card" style="padding-top: 5px; padding-bottom: 5px; padding-left: 10px;padding-right: 10px; margin-top: 0px;margin-bottom: 5px;">
                                            <div class="card-title">
                                            
                                            </div>
                                            <div class="card-body" style="margin: 0px 0px 0px 0px;">
                                                <div class="table-responsive" style="margin: 0px 0px 0px 0px;">
                                                    <table  id="memberList"class="table table-bordered w-100" style="margin:  0px 0px 0px 0px;">
                                                        <thead>
                                                            <tr>
                                                                <th scope="row">#</th>
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
                                                                            //     dependentDropDown('ddlDistrict1', 'ddlSubDiv1', 'fillSubDiv');
                                                                            //     dependentDropDown('ddlDistrict1', 'ddlPs', 'fillPoliceStation');" >
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
                                                                            //    dependentDropDown('ddlSubDiv1', 'ddlUrbRurBody', 'fillBlock');
                                                                            //   dependentDropDown('ddlSubDiv1', 'ddlPo', 'fillPostOffice');
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

                                        <div class="card" id="comparediv" style="padding-top: 5px; padding-bottom: 5px; padding-left: 10px;padding-right: 10px; margin-top: 0px;margin-bottom: 5px;">
                                            
                                            <div class="" style="min-width: 900px; scrollbar-width: none;">
                                                <div class="card-body" >
                                                    <div class="row">                              
                                                        <div class="col-lg-3 col-sm-3 col-3" style="padding-left: 2px; padding-right: 1px">
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
                                                        <div class="col-lg-3 col-sm-3 col-3" style="padding-left: 1px; padding-right: 1px">
                                                            <div class="card"  style="padding: 10px 10px 10px 10px">
                                                                <div class="card-title" style="height: 60px;">
                                                                    <div class="float-left">
                                                                        <div class="stat-icon dib">
                                                                            <i class="fa fa-address-book-o color-success border-pink"></i>
                                                                        </div>
                                                                        <h4 class="color-primary">RC Data </h4>
                                                                        <p id="rcnoHead" style="font-size: 0.7rem;"></p>
                                                                    </div>
                                         
                                                                </div>
                                                                <div class="recent-comment m-t-2">
                                                                    <div class="media cmpMemberName">                                                        
                                                                        <div class="media-body">                                                               
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcMemberName"></h4>                                                    
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMemberNameLocal">                                                        
                                                                        <div class="media-body">                                                               
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcMemberNameLocal"></h4>                                                      
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>

                                                                    <div class="media cmpSex">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcSex"></h4>     
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpDob">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcDOB"></h4>   
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpFathername">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcFatherName"></h4>    
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMothername">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcMotherName"></h4>
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMobile">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcMobile"></h4>    
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpEmail">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcEmail"></h4>   
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpAadhaar">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcAadhar"></h4>
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpAadhaar">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="rcAddress"></h4>
                                                                                
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <!-- /# card -->
                                                        </div>
                                                        <!-- /# column -->
                                                        <div class="col-lg-3 col-sm-3 col-3" style="padding-left: 1px; padding-right: 1px">
                                                            <div class="card"  style="padding: 10px 10px 10px 10px">
                                                                <div class="card-title" style="height: 60px;">
                                                                    <div class="float-left">
                                                                        <div class="stat-icon dib">
                                                                            <i class="fa fa-id-card color-success border-pink"></i>
                                                                        </div>
                                                                        <h4 class="color-primary">Aadhaar Data </h4>
                                                                        <p id="aadhaarnoHead" style="font-size: 0.7rem;"></p>
                                                                    </div>
                                                                   
                                                                </div>
                                                                <div class="recent-comment m-t-2">
                                                                    <div class="media cmpMemberName" style="padding-top: 1px;">
                                                                        <div class="media-left" >                                                           
                                                                            <img class="media-object" height="40px" width="40px" src="assets/images/user.jpg"   alt="img" >
                                                                        </div>
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarMemberName"></h4>
                                                                            <p></p>                                                            
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMemberNameLocal">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarMemberNameLocal"></h4>                                                                                                                     
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>

                                                                    <div class="media cmpSex">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarSex"></h4>    
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpDob">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarDOB"></h4>
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpFathername">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarFatherName"></h4>    
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMothername">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarMotherName"></h4>
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMobile">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarMobile"></h4>  
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpEmail">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarEmail"></h4>    
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpAadhaar">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarAadhar"></h4>                           
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpAddress">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="aadhaarAddress"></h4>
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                           
                                                        </div>
                                                        <!-- /# column -->
                                                        <div class="col-lg-3 col-sm-3 col-3" style="padding-left: 1px; padding-right: 1px">
                                                            <div class="card" id="" style="padding: 10px 10px 10px 10px">
                                                                <div class="card-title" style="height: 60px;">                                                      
                                                                    <div class="stat-icon dib">
                                                                        <i class="fa fa-save color-success border-pink"></i>
                                                                    </div>
                                                                    <h4 class="color-primary">Final Data </h4>
                                                                </div>
                                                               <div class="recent-comment m-t-2">
                                                                    <div class="media cmpMemberName" style="padding-top: 1px;">
                                                                        <div class="media-left" >                                                           
                                                                            <img class="media-object" height="40px" width="40px" src="assets/images/user.jpg"   alt="img" >
                                                                        </div>
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="finalMemberName"></h4>
                                                                            <p></p>                                                            
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMemberNameLocal">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="finalMemberNameLocal"></h4>                                                                                                                     
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>

                                                                    <div class="media cmpSex">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="finalSex"></h4>    
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpDob">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="finalDOB"></h4>
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpFathername">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="finalFatherName"></h4>    
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMothername">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="finalMotherName"></h4>
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpMobile">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="finalMobile"></h4>  
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpEmail">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="finalEmail"></h4>    
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                                    <div class="media cmpAadhaar">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="finalAadhar"></h4>
                                                                         </div>
                                                                    </div>
                                                                   <div class="media cmpAddress">
                                                                        <div class="media-body">
                                                                            <h4 class="media-heading2 color-dark font-text" style="font-size: 0.85rem;font-weight: normal;" id="finalAddress"></h4>
                                                                            <p></p>                                                           
                                                                        </div>
                                                                    </div>
                                                    <!-- /# row -->
                                                </div>
                                            </div>
                                              <div class="col-md-12 text-center form-inline" id="bttnId">
                                                  <form>
                                                      <button class="btn btn-success btn-flat btn-addon m-b-10 m-l-5 ti-thumb-up form-inline "  id="acceptBttn" type="submit"  style=background-color:green;>Accept </button>
                                                      <button class="btn btn-success btn-flat btn-addon m-b-10 m-l-5 ti-thumb-down form-inline" id="rejectBttn" type="submit"  style=background-color:red;>Reject </button>
                                                   </form>
                                             </div>
                                              <div class="card-footer pr d-flex justify-content-center">                                  
                                                
                                            </div> 
                                        </div>
                                    </div>
                                 
                                </div>
                            
                        </div>
                     

                    <jsp:include page="import/footernote.jsp"></jsp:include>  

                        </section>
                    </div>
                </div>
            </div>

        <jsp:include page="import/footer.jsp"></jsp:include>  
            <!-- in page script -->
            <script src="assets/js/lib/toastr/toastr.min.js"></script>
            <script src="assets/js/lib/select2/select2.full.min.js"></script>

        </body>
            <script>
            $(document).ready(function(){
            
                                                                                        $.ajax({
                                                                                        "url": "${pageContext.request.contextPath}/sasApiTest?rcMemberId=" + <%=  request.getParameter("memberid") %>,
                                                                                        cache: false,
                                                                                        processData: false,
                                                                                        // contentType: false,
                                                                                        type: 'POST',
                                                                                        dataType: 'json',
//                                                                                        beforeSend: function () {
//                                                                                           $('#aadhaarModal').modal('show');
//
//                                                                                            $('#loader').show();
//                                                                                            $(".card").css("opacity", 0.2);
//                                                                                            $(".card").find("input, button, submit, textarea, select").attr("disabled", "disabled");
//                                                                                            $("#loader").css({"display": "block"});
//                                                                                        },
//                                                                                        complete: function () {
////                                    $('#aadhaarModal').modal('hide');
////                                    $(".modal-backdrop").remove();
//                                                                                            $('#loader').hide();
//                                                                                            $(".card").css("opacity", 1.0);
//                                                                                            $(".card").find("input, button, submit, textarea, select").removeAttr("disabled", "disabled");
//                                                                                        },
                                                                                       success: function (result) {
                                                                                            var finalData = result["aaData"][0];
                                                                                            //  console.log(aadhaarData['mobile']);
                                                                                         
                                                                                           // $('#aadhaarnoHead').text('Aadhaar: ' + finalData['uid']);
                                                                                            setAllFinalValue(finalData);
                                                                                        }
                                                                                       
                                                                                    });
//     $('#pendingTable tbody').on('click', 'button', function (e) {
// 
//
//        if (parseInt(this.value) === 1) {
//            var table2 = $('#pendingTable').DataTable();
//            var rowRcData = table2.row($(this).parents('tr')).data(); //alert(table2.row($(this).parents('tr')).data());
//
//
//           window.location.href = "approverPage.jsp?memberid=" +rowRcData['rc_ration_card_memberid'];
//            //   }); //   end ekyc aadhaar click
//
//        } // end if value =1
////    });
//                                                          $('#acceptBttn').on('click', 'button' , function (e){
//                                                              alert(if(parseInt(this.value)===1));
//                                                              if(parseInt(this.value)===1){
//                                                              window.location.href ="CheckerPage.jsp"}
//                                                          });
//                                                          $('#rejectBttn').on('click', 'button' , function (f){
//                                                              if(parseInt(this.value)===1){
//                                                              window.location.href ="CheckerPage.jsp"}
//                                                          });
                                              

                                                
});
                                                           function  setAllFinalValue(finalData) {
                                                                        checkEmptyAndSet('rcMemberName', finalData['rc_member_name_en'] , finalData['rc_member_name_en_markrevision']);
                                                                        checkEmptyAndSet('rcMemberNameLocal',finalData['rc_member_name_ll'] , finalData['rc_member_name_ll_markrevision']);
                                                                        checkEmptyAndSet('rcSex', finalData['rc_gender'] , finalData['rc_gender_markrevision']);
                                                                        checkEmptyAndSet('rcDOB', finalData['rc_member_dob'] , finalData['rc_member_dob_markrevision']);
                                                                        checkEmptyAndSet('rcFatherName', finalData['rc_father_name'] , finalData['rc_father_name_markrevision']);
                                                                        checkEmptyAndSet('rcMotherName', finalData['rc_mother_name'] , finalData['rc_mother_name_markrevision']);
                                                                        checkEmptyAndSet('rcMobile', finalData['rc_mobile'] , finalData['rc_mobile_markrevision']);
//                                                                        checkEmptyAndSet('rcEmail', finalData['']);
//                                                                        checkEmptyAndSet('rcAadhar', finalData['']);
//                                                                        checkEmptyAndSet('rcAddress', rowRcData['lgd_address']);
                                                                        checkEmptyAndSet('aadhaarMemberName', finalData['aadhaar_member_name_en'] , finalData['aadhaar_member_name_en_markrevision']);
                                                                        checkEmptyAndSet('aadhaarMemberNameLocal', finalData['aadhaar_member_name_ll'] , finalData['aadhaar_member_name_ll_markrevision']);
//                                                                        checkEmptyAndSet('aadhaarMemberId', finalData[''] , finalData[''];
                                                                        checkEmptyAndSet('aadhaarSex', finalData['aadhaar_gender'] , finalData['aadhaar_gender_markrevision']);
                                                                        checkEmptyAndSet('aadhaarDOB', finalData['aadhaar_member_dob'] , finalData['aadhaar_member_dob_markrevision']);
                                                                        checkEmptyAndSet('aadhaarFatherName', finalData['aadhaar_father_name'] , finalData['aadhaar_father_name_markrevision']);
                                                                        checkEmptyAndSet('aadhaarMotherName', finalData['aadhaar_mother_name'] , finalData['aadhaar_mother_name_markrevision']);
                                                                        checkEmptyAndSet('aadhaarMobile', finalData[''] , finalData['']);
                                                                        checkEmptyAndSet('aadhaarEmail', finalData[''] , finalData['']);
                                                                        checkEmptyAndSet('aadhaarAadhar', finalData[''] , finalData['']);
                                                                        checkEmptyAndSet('aadhaarAddress', finalData[''] , finalData['']);//
                                                                        
                                                                        
                                                                    }
                                                                    function  checkEmptyAndSet(fieldid, value, markForRev) {
//                                                                        alert(parseInt(this.markForRev));
                                                                            $("#" + fieldid).html(value);                                                                        
                                                                            if (markForRev == 0) {
                                                                            $("#" + fieldid).addClass('greenStyle');
                                                                        } else {
                                                                           $("#" + fieldid).addClass('redStyle');
                                                                        }
                                                                    }
                                                                    
                                                                    function finalset(finalData){
                                                                        
                                                                        
                                                                        finalValue('finalMemberName', finalData['final_member_name_en']);
                                                                        finalValue('finalMemberNameLocal', finalData['final_member_name_ll']);
                                                                        finalValue('finalSex', finalData['final_gender']);
                                                                        finalValue('finalDOB', finalData['final_member_dob']);
                                                                        finalValue('finalFatherName', finalData['final_father_name']);
                                                                        finalValue('finalMotherName', finalData['final_mother_name']);
                                                                        finalValue('finalMobile', finalData['final_mobile']);
                                                                        finalValue('finalEmail', finalData['final_email']);
                                                                        finalValue('finalAadhar', finalData['aadhaar_uid']);
                                                                        finalValue('finalAddress', finalData['']);
                                                                    }
                                                                    
                                                                    function finalValue(fieldid){
                                                                        $("#" + fieldid).html(value);
                                                                    }
    </script>
 
