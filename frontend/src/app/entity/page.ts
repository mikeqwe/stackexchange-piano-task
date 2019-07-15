export interface Page<T> {
  content: T[];
  number: number;
  totalPages: number;
  totalElements: number;
  last: boolean;
  first: boolean;
}
