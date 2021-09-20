import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { RouterModule } from "@angular/router";
import { ToastrModule } from 'ngx-toastr';

import { AppComponent } from "./app.component";
import { AdminLayoutComponent } from "./layouts/admin-layout/admin-layout.component";
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';

import { NgbModule } from "@ng-bootstrap/ng-bootstrap";

import { AppRoutingModule } from "./app-routing.module";
import { ComponentsModule } from "./components/components.module";
import { LoginComponent } from './login/login.component';
import { DialogBoxComponent } from "./dialog-box/dialog-box.component";
import {MatDialogModule} from "@angular/material/dialog";
import {MatIconModule} from "@angular/material/icon";
@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ComponentsModule,
    NgbModule,
    RouterModule,
    AppRoutingModule,
    MatDialogModule,
    MatIconModule,
    ToastrModule.forRoot()
  ],
  declarations: [AppComponent, AdminLayoutComponent, AuthLayoutComponent, LoginComponent, DialogBoxComponent],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents:[DialogBoxComponent]
})
export class AppModule {}
