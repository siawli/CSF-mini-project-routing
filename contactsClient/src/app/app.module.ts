import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import  { Router, RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ContactFormComponent } from './components/contact-form.component';
import { ListContactsComponent } from './components/list-contacts.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ContactService } from './services';

const appRoutes: Routes = [
  {path: 'addContact', component: ContactFormComponent},
  {path: 'listContacts', component: ListContactsComponent},
  {path: '**', redirectTo:'/', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    ContactFormComponent,
    ListContactsComponent
  ],
  imports: [
    BrowserModule, FormsModule, 
    ReactiveFormsModule, HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ContactService],
  bootstrap: [AppComponent]
})
export class AppModule { }
