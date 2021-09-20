import { HttpClient, HttpStatusCode } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable, tap } from 'rxjs';
import { Custodian } from '../model/custodian';
@Injectable({
  providedIn: 'root'
})
export class CustodianService {
  usernme:string;
  custodian:string;
  constructor(private http:HttpClient) { }

  public getCustodianNameByID(id:any):Observable<Custodian>{

    let url="http://localhost:8282/api/custodian/"+id;
    return this.http.get<Custodian>(url).pipe()
    }

    public getAllCustodians():Observable<Custodian[]>{

      let url="http://localhost:8282/api/custodians";
      return this.http.get<Custodian[]>(url).pipe(tap(res=>{
        console.log(res);
      }))
      }

      
        
        
        
    
      


}
