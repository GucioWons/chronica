/* tslint:disable */
/* eslint-disable */

export namespace DTOs {

    export interface AccountDTO extends EntityDTO {
        active: boolean;
        createdAt: DateAsString;
        deprecated: boolean;
        mail: string;
        password: string;
        person: PersonDTO;
        phoneNumber: number;
        roles: Role[];
        username: string;
    }

    export interface AlertDTO extends NotificationDTO {
        priority: Priority;
    }

    export interface BaseChainDTO extends EntityDTO {
        title: string;
        type: ChainType;
    }

    export interface ChainDTO extends EntityDTO {
        baseChain: BaseChainDTO;
        childChains: ChildChainDTO[];
        description: string;
        estimation: number;
        points: number;
        timeLeft: number;
        title: string;
        type: ChainType;
    }

    export interface ChildChainDTO extends EntityDTO {
        childChains: ChildChainDTO[];
        title: string;
        type: ChainType;
    }

    export interface EntityDTO {
        id: number;
    }

    export interface ErrorDTO {
        apiPath: string;
        at: DateAsString;
        message: string;
    }

    export interface GroupDTO extends EntityDTO {
        category: Category;
        deprecated: boolean;
        description: string;
        name: string;
        ownerId: number;
    }

    export interface InvitationDTO extends NotificationDTO {
        accepted: boolean;
        acceptedAt: DateAsString;
        groupId: number;
        inviterId: number;
    }

    export interface LinkConfirmationDTO {
        confirmedAt: DateAsString;
        isActivated: boolean;
        mail: string;
    }

    export interface MessageDTO extends NotificationDTO {
        messageFromUserId: number;
    }

    export interface NotificationDTO extends EntityDTO {
        content: string;
        createdAt: DateAsString;
        deprecated: boolean;
        receiverId: number;
        seen: boolean;
        title: string;
        viewAt: DateAsString;
    }

    export interface PaginationAndSortDTO {
        pageNumber: number;
        pageSize: number;
        sortDirection: Direction;
        sortField: string;
    }

    export interface PersonDTO extends EntityDTO {
        age: number;
        lastName: string;
        name: string;
    }

    export interface ProjectDTO extends EntityDTO {
        createdDate: DateAsString;
        deprecated: boolean;
        groupId: number;
        lastChangeDate: DateAsString;
        name: string;
    }

    export interface SignInDTO {
        mail: string;
        password: string;
    }

    export interface SignInResultDTO {
        account: AccountDTO;
        token: string;
    }

    export interface SnapDTO extends EntityDTO {
        activity: Activity;
        chainId: number;
        creationDate: DateAsString;
        deprecated: boolean;
        description: string;
        logDate: DateAsString;
        time: number;
    }

    export type DateAsString = string;

    export enum Activity {
        DEVELOPMENT = "DEVELOPMENT",
        MANAGEMENT = "MANAGEMENT",
        MEETING = "MEETING",
        OTHER = "OTHER",
    }

    export enum Category {
        IT = "IT",
        SALESFORCE = "SALESFORCE",
        OTHER = "OTHER",
    }

    export enum ChainType {
        EPIC = "EPIC",
        STORY = "STORY",
        TASK = "TASK",
        BUG = "BUG",
    }

    export enum Direction {
        ASC = "ASC",
        DESC = "DESC",
    }

    export enum Priority {
        IMPORTANT = "IMPORTANT",
        SPAM = "SPAM",
        DEFAULT = "DEFAULT",
    }

    export enum Role {
        ADMINISTRATOR = "ADMINISTRATOR",
        USER = "USER",
        SYSTEM = "SYSTEM",
    }

}
