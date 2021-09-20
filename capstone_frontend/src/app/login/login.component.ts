import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs';
import { Custodian } from '../model/custodian';
import { CustodianService } from '../service/custodian.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private custodianServce:CustodianService, private router:Router) { }

  ngOnInit(): void {
    this.custodianServce.getAllCustodians().subscribe(up =>{
      this.users=up.map(item=>{
        return new Custodian(
          item.cust_id,
          item.cust_name,
          item.password
        )
      })
    })
   
  }
  @ViewChild('f')
  form:any;
  flag=false;
  model:Custodian = new Custodian();
  users=new Array<Custodian>();
  userlogged:string;
  cust:string;
  onLogin(){
    
    const user= (<HTMLInputElement>document.getElementById('user')).value;
    const password = (<HTMLInputElement>document.getElementById('pass')).value;
    for(let item of this.users){
      console.log(item.password)
      if((item.cust_id===user) && (item.password === password)){
        this.userlogged=item.cust_id;
        this.cust=item.cust_name;
        localStorage.setItem('id',this.userlogged);
        localStorage.setItem('cust_name',this.cust);
        this.flag=true;
        break;
      }
    }
    this.custodianServce.usernme=this.userlogged;
    this.custodianServce.custodian=this.cust;
    if(this.flag){
      this.router.navigateByUrl("/home");
    }
    else{
      alert("Invalid Username/Password");
    }

}}
