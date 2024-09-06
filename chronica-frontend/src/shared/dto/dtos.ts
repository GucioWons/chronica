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
        userRoles: UserRole[];
        username: string;
    }

    export interface AlertDTO extends NotificationDTO {
        alertPriority: AlertPriority;
        type: "alert";
    }

    export interface BaseChainDTO extends EntityDTO {
        chainType: ChainType;
        title: string;
    }

    export interface ChainDTO extends EntityDTO {
        baseChain: BaseChainDTO;
        chainType: ChainType;
        childChains: ChildChainDTO[];
        description: string;
        estimation: number;
        points: number;
        timeLeft: number;
        title: string;
    }

    export interface ChildChainDTO extends EntityDTO {
        chainType: ChainType;
        childChains: ChildChainDTO[];
        title: string;
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
        category: GroupCategory;
        description: string;
        name: string;
        ownerId: number;
    }

    export interface InvitationDTO extends NotificationDTO {
        accepted: boolean;
        acceptedAt: DateAsString;
        groupId: number;
        inviterId: number;
        type: "invitation";
    }

    export interface LinkConfirmationDTO {
        confirmedAt: DateAsString;
        isActivated: boolean;
        mail: string;
    }

    export interface MessageDTO extends NotificationDTO {
        messageFromUserId: number;
        type: "message";
    }

    export interface NotificationDTO extends EntityDTO {
        content: string;
        createdAt: DateAsString;
        deprecated: boolean;
        receiverId: number;
        seen: boolean;
        title: string;
        type: "NotificationDTO" | "alert" | "invitation" | "message";
        viewAt: DateAsString;
    }

    export interface PaginationAndSortDTO {
        pageNumber: number;
        pageSize: number;
        sortDirection: Direction;
        sortField: string;
    }

    export interface PersonDTO extends EntityDTO {
        lastName: string;
        name: string;
    }

    export interface ProjectDTO extends EntityDTO {
        createdDate?: Nullable<DateAsString>;
        groupId: number;
        lastChangeDate?: Nullable<DateAsString>;
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
        chainId: number;
        creationDate: DateAsString;
        description: string;
        logDate: DateAsString;
        snapActivity: SnapActivity;
        time: number;
    }

    export type DateAsString = string;

    export type NotificationDTOUnion = AlertDTO | InvitationDTO | MessageDTO;

    export type Nullable<T> = T | null | undefined;

    export enum AlertPriority {
        IMPORTANT = "IMPORTANT",
        SPAM = "SPAM",
        DEFAULT = "DEFAULT",
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

    export enum GroupCategory {
        IT = "IT",
        SALESFORCE = "SALESFORCE",
        OTHER = "OTHER",
    }

    export enum SnapActivity {
        DEVELOPMENT = "DEVELOPMENT",
        MANAGEMENT = "MANAGEMENT",
        MEETING = "MEETING",
        OTHER = "OTHER",
    }

    export enum UserRole {
        ADMINISTRATOR = "ADMINISTRATOR",
        USER = "USER",
    }

}
