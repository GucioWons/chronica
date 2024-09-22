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
        title: string;
        type: ChainType;
    }

    export interface ChainDTO extends EntityDTO {
        baseChain?: Nullable<ChainSelectDTO>;
        childChains?: Nullable<ChildChainDTO[]>;
        description: string;
        estimation?: Nullable<number>;
        points?: Nullable<number>;
        timeLeft?: Nullable<number>;
        title: string;
        type: ChainType;
    }

    export interface ChainSelectDTO extends EntityDTO {
        title: string;
        type: ChainType;
    }

    export interface ChildChainDTO extends ChainSelectDTO {
        childChains: ChildChainDTO[];
    }

    export interface EntityDTO {
        id: number;
    }

    export interface ErrorDTO {
        apiPath: string;
        at: DateAsString;
        message: ErrorMessage;
        properties: { [index: string]: any };
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

    export enum ErrorMessage {
        UNEXPECTED_EXCEPTION = "UNEXPECTED_EXCEPTION",
        NOT_IMPLEMENTED_EXCEPTION = "NOT_IMPLEMENTED_EXCEPTION",
        NO_ENTITY_EXCEPTION = "NO_ENTITY_EXCEPTION",
        INHERITANCE_LEVEL_EXCEPTION = "INHERITANCE_LEVEL_EXCEPTION",
        INHERITANCE_LOOP_EXCEPTION = "INHERITANCE_LOOP_EXCEPTION",
        WRONG_MAPPER_EXCEPTION = "WRONG_MAPPER_EXCEPTION",
        AUTHORIZATION_EXCEPTION = "AUTHORIZATION_EXCEPTION",
        UNEXPECTED_JWT_EXCEPTION = "UNEXPECTED_JWT_EXCEPTION",
        EXPIRED_ACCESS_TOKEN_EXCEPTION = "EXPIRED_ACCESS_TOKEN_EXCEPTION",
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
