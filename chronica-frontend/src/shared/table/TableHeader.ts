export interface TableHeader<T> {
    name: string,
    field: keyof T
    type: "string" | "number" | "boolean" | "date"
}