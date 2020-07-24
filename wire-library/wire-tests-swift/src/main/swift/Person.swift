// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.kotlin.person.Person in person.proto
import Foundation
import Wire

/**
 * Message representing a person, includes their name, unique ID number, email and phone number.
 */
public struct Person {

    /**
     * The customer's full name.
     */
    public var name: String
    /**
     * The customer's ID number.
     */
    public var id: Int32
    /**
     * Email address for the customer.
     */
    public var email: String?
    /**
     * A list of the customer's phone numbers.
     */
    public var phone: [PhoneNumber]
    public var aliases: [String]
    public var unknownFields: Data = .init()

    public init(
        name: String,
        id: Int32,
        email: String? = nil,
        phone: [PhoneNumber] = [],
        aliases: [String] = []
    ) {
        self.name = name
        self.id = id
        self.email = email
        self.phone = phone
        self.aliases = aliases
    }

    /**
     * Represents the type of the phone number: mobile, home or work.
     */
    public enum PhoneType : UInt32, CaseIterable, Codable {

        case MOBILE = 0
        case HOME = 1
        case WORK = 2

    }

    public struct PhoneNumber {

        /**
         * The customer's phone number.
         */
        public var number: String
        /**
         * The type of phone stored here.
         */
        public var type: PhoneType?
        public var unknownFields: Data = .init()

        public init(number: String, type: PhoneType? = nil) {
            self.number = number
            self.type = type
        }

    }

}

extension Person.PhoneNumber : Equatable {
}

extension Person.PhoneNumber : Hashable {
}

extension Person.PhoneNumber : Proto2Codable {
    public init(from reader: ProtoReader) throws {
        var number: String? = nil
        var type: Person.PhoneType? = nil

        let token = try reader.beginMessage()
        while let tag = try reader.nextTag(token: token) {
            switch tag {
            case 1: number = try reader.decode(String.self)
            case 2: type = try reader.decode(Person.PhoneType.self)
            default: try reader.readUnknownField(tag: tag)
            }
        }
        self.unknownFields = try reader.endMessage(token: token)

        self.number = try Person.PhoneNumber.checkIfMissing(number, "number")
        self.type = type
    }

    public func encode(to writer: ProtoWriter) throws {
        try writer.encode(tag: 1, value: number)
        try writer.encode(tag: 2, value: type)
        try writer.writeUnknownFields(unknownFields)
    }
}

extension Person.PhoneNumber : Codable {
    public enum CodingKeys : String, CodingKey {

        case number
        case type

    }
}

extension Person : Equatable {
}

extension Person : Hashable {
}

extension Person : Proto2Codable {
    public init(from reader: ProtoReader) throws {
        var name: String? = nil
        var id: Int32? = nil
        var email: String? = nil
        var phone: [Person.PhoneNumber] = []
        var aliases: [String] = []

        let token = try reader.beginMessage()
        while let tag = try reader.nextTag(token: token) {
            switch tag {
            case 1: name = try reader.decode(String.self)
            case 2: id = try reader.decode(Int32.self)
            case 3: email = try reader.decode(String.self)
            case 4: try reader.decode(into: &phone)
            case 5: try reader.decode(into: &aliases)
            default: try reader.readUnknownField(tag: tag)
            }
        }
        self.unknownFields = try reader.endMessage(token: token)

        self.name = try Person.checkIfMissing(name, "name")
        self.id = try Person.checkIfMissing(id, "id")
        self.email = email
        self.phone = try Person.checkIfMissing(phone, "phone")
        self.aliases = try Person.checkIfMissing(aliases, "aliases")
    }

    public func encode(to writer: ProtoWriter) throws {
        try writer.encode(tag: 1, value: name)
        try writer.encode(tag: 2, value: id)
        try writer.encode(tag: 3, value: email)
        try writer.encode(tag: 4, value: phone)
        try writer.encode(tag: 5, value: aliases)
        try writer.writeUnknownFields(unknownFields)
    }
}

extension Person : Codable {
    public enum CodingKeys : String, CodingKey {

        case name
        case id
        case email
        case phone
        case aliases

    }
}
