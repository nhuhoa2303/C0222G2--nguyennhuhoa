import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/Product';
import {CookieService} from '../login/service/cookie.service';
import {Category} from '../model/Category';

const API_URL = `${environment.apiUrl}`;


// @ts-ignore
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private PRODUCT = API_URL + 'product';
  private CATEGORY = API_URL + 'category';
  private LAPTOP = API_URL + 'laptop/page';
  private PHONE = API_URL + 'phone/page';
  private NEAR_DAY = API_URL + 'near-day';
  private DETAIL = API_URL + 'detail/';


  private SEARCH = API_URL + 'search';


  private header = 'Bearer ' + this.cookieService.getCookie('jwToken');

  constructor(private httpClient: HttpClient, private cookieService: CookieService) {
  }

  searchProduct(nameSearch: string): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.SEARCH + `?nameSearch=${nameSearch}`, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  getAll(page: number): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.PRODUCT + `?page=${page}`, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  getAllCategory(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.CATEGORY, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  getLaptop(page: number, nameProduct: string, beforePrice: string, firstPrice: string, sort: string): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.LAPTOP + `?page=${page}` + `&nameProduct=${nameProduct}&beforePrice=${beforePrice}&firstPrice=${firstPrice}&sort=${sort}`, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  getPhone(page: number, nameProduct: string, beforePrice: string, firstPrice: string, sort: string): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.PHONE + `?page=${page}` + `&nameProduct=${nameProduct}&beforePrice=${beforePrice}&firstPrice=${firstPrice}&sort=${sort}`, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  getProductNearDay(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.NEAR_DAY, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

  getProductById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(this.DETAIL + `${id}`, {headers: new HttpHeaders({'authorization': this.header})}).pipe();
  }

}
